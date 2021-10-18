package com.onufrei.sn.dao;

import com.onufrei.sn.constants.Roles;
import com.onufrei.sn.dto.AccountRegistrationInDto;
import com.onufrei.sn.exceptions.AuthorityException;
import com.onufrei.sn.mapper.AccountMapper;
import com.onufrei.sn.mapper.AuthorityMapper;
import com.onufrei.sn.mapper.ProfileMapper;
import com.onufrei.sn.model.Account;
import com.onufrei.sn.model.Authority;
import com.onufrei.sn.model.Profile;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class UserRegistrationDao {

	private final SqlSessionFactory sessionFactory;

	public UserRegistrationDao(SqlSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Long register(AccountRegistrationInDto accountRegistration) {
		Long profileId;

		try(SqlSession sqlSession = sessionFactory.openSession()) {
			AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
			ProfileMapper profileMapper = sqlSession.getMapper(ProfileMapper.class);
			AuthorityMapper authorityMapper = sqlSession.getMapper(AuthorityMapper.class);

			Account newAccount = Account.builder()
					.username(accountRegistration.getUsername())
					.password(DigestUtils.sha256Hex(accountRegistration.getPassword()))
					.build();

			Profile newProfile = Profile.builder()
					.name(accountRegistration.getName())
					.dateOfBirth(accountRegistration.getDateOfBirth())
					.profileImageUrl(accountRegistration.getProfileImage())
					.status(accountRegistration.getStatus())
					.build();

			accountMapper.add(newAccount);

			Authority authority = authorityMapper.getAll().stream().filter(it -> it.getName().equals(Roles.ROLE_USER.getValue())).findFirst().orElse(null);
			if (Objects.isNull(authority)) {
				sqlSession.rollback();
				throw new AuthorityException("Unable to find " + Roles.ROLE_USER.getValue() + " authority");
			}
			authorityMapper.addToAccount(newAccount.getId(), authority.getId());
			newProfile.setAccountId(newAccount.getId());
			profileMapper.add(newProfile);

			profileId = newProfile.getId();
		}

		return profileId;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void unregister(Long accountId) {
		try (SqlSession sqlSession = sessionFactory.openSession()) {
			AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
			accountMapper.delete(accountId);
		}
	}


}
