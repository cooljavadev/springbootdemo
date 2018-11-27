package com.group.company.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group.company.controller.exception.UserProfileNotFound;
import com.group.company.model.UserProfile;
import com.group.company.service.ProfileService;

@RestController
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;

	@GetMapping("/profiles/{id}")
	public ResponseEntity<UserProfile> getUserProfile(@PathVariable int id) {
	
		Optional<UserProfile> userProfileOut= profileService.getUserProfile(id);
			if(!userProfileOut.isPresent()) {
				throw new UserProfileNotFound("User Not found");
			}
			return new ResponseEntity<UserProfile>(userProfileOut.get(), HttpStatus.OK);	
			
	}
	
	
	@PostMapping("/profiles")
	public ResponseEntity<UserProfile> createUserProfile(@RequestBody UserProfile userProfileIn) {
	
			UserProfile userProfileOut= profileService.createUserProfiile(userProfileIn);
			return new ResponseEntity<UserProfile>(userProfileOut, HttpStatus.OK);
		
			
	}
	
	
	@PutMapping("/profiles/{id}")
	public ResponseEntity<UserProfile> updateUserProfile(@PathVariable int id,@RequestBody UserProfile modelIn) {
	
			UserProfile userProfileIn= new UserProfile(id, modelIn.getName(),modelIn.getQualification(),modelIn.getInterest(),modelIn.getLinkedInURL());
			UserProfile userProfileOut= profileService.updateUserProfile(userProfileIn);
			return new ResponseEntity<UserProfile>(userProfileOut, HttpStatus.OK);
			
	}
	
	
	@DeleteMapping("/profiles/{id}")
	public void deleteUserProfile(@PathVariable int id) {
		
			profileService.deleteUserProfile(id);
				
	}
	
}
