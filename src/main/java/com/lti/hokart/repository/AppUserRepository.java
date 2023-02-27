package com.lti.hokart.repository;

import com.lti.hokart.model.AppUser;
import com.lti.hokart.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
}
