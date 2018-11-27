package com.group.company.serviceImpl;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.company.model.UserProfile;
import com.group.company.repository.UserProfileRepository;
import com.group.company.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private UserProfileRepository userProfileRepo;
	

	@Override
	public UserProfile createUserProfiile(UserProfile modelIn) {
		UserProfile userProfileOut = new UserProfile(modelIn.getName(),modelIn.getQualification(),modelIn.getInterest(),modelIn.getLinkedInURL());
		
		return userProfileRepo.save(userProfileOut);
	}

	@Override
	public Optional<UserProfile> getUserProfile(int id) {
		Optional<UserProfile> userProfileOut= userProfileRepo.findById(id);
			return userProfileOut;
		
	}

	@Override
	public UserProfile updateUserProfile(UserProfile modelIn) {
		UserProfile updatedUserProfile = userProfileRepo.save(modelIn);
		return updatedUserProfile;
	}

	@Override
	public void deleteUserProfile(int id) {
		Optional<UserProfile> userProfileToBeDeleted= getUserProfile(id);
		if(userProfileToBeDeleted.isPresent() ) {
		userProfileRepo.deleteById(id);
		}
		
	}

}
