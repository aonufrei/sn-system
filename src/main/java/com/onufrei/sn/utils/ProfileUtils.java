package com.onufrei.sn.utils;

import com.onufrei.sn.dto.ProfileDto;
import com.onufrei.sn.dto.ProfileInDto;
import com.onufrei.sn.model.Profile;

public class ProfileUtils {

	public static ProfileDto toDto(Profile profile) {
		if (profile == null) return null;

		return ProfileDto.builder()
				.id(profile.getId())
				.name(profile.getName())
				.status(profile.getStatus())
				.accountId(profile.getAccountId())
				.dateOfBirth(profile.getDateOfBirth())
				.profileImageUrl(profile.getProfileImageUrl())
				.hobbies(profile.getHobbies())
				.createdAt(profile.getCreatedAt())
				.modifiedAt(profile.getModifiedAt())
				.build();
	}

	public static Profile toModel(ProfileInDto profile) {
		if (profile == null) return null;

		return Profile.builder()
				.name(profile.getName())
				.status(profile.getStatus())
				.accountId(profile.getAccountId())
				.dateOfBirth(profile.getDateOfBirth())
				.profileImageUrl(profile.getProfileImageUrl())
				.hobbies(profile.getHobbies())
				.build();
	}

	public static ProfileInDto toInDto(ProfileDto profile) {
		if (profile == null) return null;

		return ProfileInDto.builder()
				.name(profile.getName())
				.status(profile.getStatus())
				.accountId(profile.getAccountId())
				.dateOfBirth(profile.getDateOfBirth())
				.profileImageUrl(profile.getProfileImageUrl())
				.hobbies(profile.getHobbies())
				.build();
	}
	
}
