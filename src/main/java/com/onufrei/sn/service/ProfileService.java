package com.onufrei.sn.service;

import com.onufrei.sn.dao.ProfileDao;
import com.onufrei.sn.dto.ProfileDto;
import com.onufrei.sn.dto.ProfileInDto;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

	private final ProfileDao profileDao;

	public ProfileService(ProfileDao profileDao) {
		this.profileDao = profileDao;
	}

	public Boolean add(ProfileInDto profile){
		return profileDao.add(profile) > 0;
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
}
