package com.onufrei.sn.service;

import com.onufrei.sn.dao.ProfileDao;
import com.onufrei.sn.dao.UserRegistrationDao;
import com.onufrei.sn.dto.AccountRegistrationInDto;
import com.onufrei.sn.dto.ProfileDto;
import com.onufrei.sn.dto.ProfileInDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

	private final ProfileDao profileDao;
	private final UserRegistrationDao userRegistrationDao;

	public ProfileService(ProfileDao profileDao, UserRegistrationDao userRegistrationDao) {
		this.profileDao = profileDao;
		this.userRegistrationDao = userRegistrationDao;
	}

	public Boolean add(ProfileInDto profile){
		return profileDao.add(profile) > 0;
	}

	/**
	 * Should be used for regular user registration
	 * @return id of newly created User Profile
	 */
	public Long register(AccountRegistrationInDto userRegistration) {
		if (StringUtils.isEmpty(userRegistration.getProfileImage())) {
			userRegistration.setProfileImage(getAvatarForUser(userRegistration.getUsername()));
		}

		return userRegistrationDao.register(userRegistration);
	}

	/**
	 * Should be used for regular user unregistration
	 */
	public void unregister(Long accountId) {
		userRegistrationDao.unregister(accountId);
	}


	public Boolean update(Long profileId, ProfileInDto profile){
		return profileDao.update(profileId, profile) > 0;
	}

	public void delete(Long id){
		profileDao.delete(id);
	}

	public ProfileDto getByAccountId(Long accountId){
		return profileDao.getByAccountId(accountId);
	}

	public ProfileDto getById(Long id){
		return profileDao.getById(id);
	}

	public String getAvatarForUser(String username) {
		return "https://avatars.dicebear.com/api/avataaars/" + username + ".svg";
	}
}
