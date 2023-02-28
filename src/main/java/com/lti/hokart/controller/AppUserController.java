package com.lti.hokart.controller;

import com.lti.hokart.model.AppUser;
import com.lti.hokart.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/users"})
public class AppUserController {
    @Autowired
    AppUserService appUserService;

    //  http://127.0.0.1:8069/api/users
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List> getAllUsers() {
        List<AppUser> appUsers = appUserService.getAllAppUsers();
        HttpStatus status = HttpStatus.FOUND;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Message", "Fetched all app users");
        ResponseEntity<List> response = new ResponseEntity<>(appUsers, headers, status);
        return response;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<AppUser> addUser(@RequestBody AppUser appUser) {
        List<AppUser> appUsers = appUserService.getAllAppUsers();
        HttpStatus httpStatus = HttpStatus.OK;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Message", "Product added successfully!");
        return new ResponseEntity<>(appUserService.addAppUser(appUser), httpHeaders, httpStatus);
    }
}
