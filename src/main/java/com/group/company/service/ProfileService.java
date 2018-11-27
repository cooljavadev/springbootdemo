package com.group.company.service;

import java.util.Optional;

import com.group.company.model.UserProfile;

public interface ProfileService {

	public UserProfile createUserProfiile(UserProfile modelIn);
	
	public Optional<UserProfile> getUserProfile(int id);
	
	public UserProfile updateUserProfile(UserProfile modelIn);
	
	public void deleteUserProfile(int id);
}
