package com.onufrei.sn.controller.rest;

import com.onufrei.sn.dto.AccountRegistrationInDto;
import com.onufrei.sn.service.ProfileService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountRestController {

	private final ProfileService profileService;

	public AccountRestController(ProfileService profileService) {
		this.profileService = profileService;
	}

	@PostMapping("/unregister/{id}")
	public void unregister(@PathVariable Long id) {
		profileService.unregister(id);
	}

	@PostMapping("/register")
	public Long registerNewUser(@RequestBody AccountRegistrationInDto newUserProfile) {
		return profileService.register(newUserProfile);
	}
}
