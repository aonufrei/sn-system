package com.onufrei.sn.controller.rest;

import com.onufrei.sn.dto.ProfileDto;
import com.onufrei.sn.dto.ProfileInDto;
import com.onufrei.sn.service.ProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profiles")
public class UserProfileRestController {

	private final ProfileService profileService;

	public UserProfileRestController(ProfileService profileService) {
		this.profileService = profileService;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Get Profile by id", description = "Returns profile info with specified id")
	public ProfileDto getProfileById(@Parameter(name = "Profile id", description = "Id of the requested profile") @PathVariable Long id) {
		return profileService.getById(id);
	}

	@GetMapping("/account/{id}")
	@Operation(summary = "Get Profile by account", description = "Returns profile by related account id")
	public ProfileDto getProfileByAccount(@Parameter(name = "Account id", description = "Id of the account related to the profile") @PathVariable Long id) {
		return profileService.getByAccountId(id);
	}

	@PostMapping
	@Operation(summary = "Add profile", description = "The passed profile will be added to the system")
	public Boolean addProfile(@Parameter(name = "Profile to add", description = "Profile that you want to add") @RequestBody ProfileInDto profile) {
		return profileService.add(profile);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Update profile", description = "Updates existing profile by specified id")
	public Boolean updateProfile(@Parameter(name = "Profile id", description = "The id of the profile you want to update") @PathVariable Long id,
			@Parameter(name = "New profile data", description = "Profile that you want to add") @RequestBody ProfileInDto profile) {
		return profileService.update(id, profile);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete profile", description = "Deletes profile by id")
	public Boolean deleteProfile(@Parameter(name = "Profile id", description = "Id of the profile you want to delete") @PathVariable Long id) {
		profileService.delete(id);
		return true;
	}

}
