package com.lti.hokart.service;

import com.lti.hokart.model.AppUser;
import com.lti.hokart.repository.AppUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService implements IAppUserService{
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public List<AppUser> getAllAppUsers() {
        List<AppUser> appUsers = appUserRepository.findAll();
        LOG.info(appUsers.toString());
        return appUsers;
    }

    @Override
    public AppUser getAppUserById(int AppUserId) {
        return null;
    }

    @Override
    public AppUser addAppUser(AppUser appUser) {
        LOG.info(appUser.toString());
        return appUserRepository.save(appUser);
    }

    @Override
    public AppUser updateAppUser(AppUser appUser) {
        this.getAppUserById(appUser.getAppUserId());
        LOG.info(appUser.toString());
        return appUserRepository.save(appUser);
    }

    @Override
    public AppUser deleteEmployee(int appUserId) {
        AppUser appUser = this.getAppUserById(appUserId);
        appUserRepository.deleteById(appUserId);
        return appUser;
    }
}
