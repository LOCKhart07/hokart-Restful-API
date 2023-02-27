package com.lti.hokart.repository;

import java.util.Date;

import com.lti.hokart.model.AppUser;
import com.lti.hokart.model.Product;
import com.lti.hokart.service.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer> {

    public User save(User user);

}
