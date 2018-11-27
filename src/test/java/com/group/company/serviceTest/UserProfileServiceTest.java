package com.group.company.serviceTest;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.group.company.model.UserProfile;
import com.group.company.repository.UserProfileRepository;
import com.group.company.service.ProfileService;
import com.group.company.serviceImpl.ProfileServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserProfileServiceTest {

	
	@TestConfiguration
    static class UserProfileServiceTestconfiguration { 
        @Bean
        public ProfileService ProfileService() {
            return new ProfileServiceImpl();
        }
    }
	
	@Autowired
	private ProfileService profileServiceObject;
	
	@MockBean
	private UserProfileRepository userRepo;
	
	@Before
	public void setUp() {
	    UserProfile userProfileIn = new UserProfile("Test", "BTECH", "Football", "Https://linkedin/test");
	 UserProfile userProfileOut =new UserProfile(1,"Test", "BTECH", "Football", "Https://linkedin/test");
	 Optional<UserProfile> userProfileOutGetMethod =Optional.of(userProfileOut);
	    Mockito.when(userRepo.save(userProfileIn))
	      .thenReturn(userProfileOut);
	    
	    
	    Mockito.when(userRepo.findById(1))
	      .thenReturn(userProfileOutGetMethod);
	    
	    Mockito.when(userRepo.findById(2))
	      .thenReturn(Optional.empty());
	    
	    
	}
	
	
	@Test
	public void validate_createUserProfile() {
		UserProfile userProfileIn = new UserProfile("Test", "BTECH", "Football", "Https://linkedin/test");
		UserProfile userProfileOut=profileServiceObject.createUserProfiile(userProfileIn);
		assertEquals("Test", userProfileOut.getName());
		assertEquals(1, userProfileOut.getId());
	}
	
	
	@Test
	public void success_getUserProfile() {
		Optional<UserProfile> userProfileOut=profileServiceObject.getUserProfile(1);
		assertEquals("Test", userProfileOut.get().getName());
		assertEquals(1, userProfileOut.get().getId());
	}
	
	@Test
	public void notfound_getUserProfile() {
		Optional<UserProfile> userProfileOut=profileServiceObject.getUserProfile(2);
		assertEquals(Optional.empty(),userProfileOut);
	}
	
	
}
