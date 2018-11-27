package com.group.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group.company.model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {

}
