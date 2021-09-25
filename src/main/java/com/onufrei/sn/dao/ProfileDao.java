package com.onufrei.sn.dao;

import com.onufrei.sn.dto.ProfileDto;
import com.onufrei.sn.dto.ProfileInDto;
import com.onufrei.sn.mapper.ProfileMapper;
import com.onufrei.sn.model.Profile;
import com.onufrei.sn.utils.ProfileUtils;
import org.springframework.stereotype.Service;

@Service
public class ProfileDao {

	private final ProfileMapper profileMapper;

	public ProfileDao(ProfileMapper profileMapper) {
		this.profileMapper = profileMapper;
	}

	public Long add(ProfileInDto profile){
		Profile profileToInsert = ProfileUtils.toModel(profile);
		profileMapper.add(profileToInsert);
		return profileToInsert.getId();
	}

	public int update(Long id, ProfileInDto profile){
		return profileMapper.update(id, ProfileUtils.toModel(profile));
	}

	public void delete(Long id){
		profileMapper.delete(id);
	}

	public ProfileDto getByAccountId(Long accountId){
		return ProfileUtils.toDto(profileMapper.getByAccountId(accountId));
	}

	public ProfileDto getById(Long id){
		return ProfileUtils.toDto(profileMapper.getById(id));
	}

}
