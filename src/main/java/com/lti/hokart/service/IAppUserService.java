package com.lti.hokart.service;

import com.lti.hokart.model.AppUser;

import java.util.List;

public interface IAppUserService {
    public abstract List<AppUser> getAllAppUsers();

    public abstract AppUser getAppUserById(int AppUserId);

    public abstract AppUser addAppUser(AppUser appUser);

    public abstract AppUser updateAppUser(AppUser appUser);

    public abstract AppUser deleteEmployee(int employeeId);
}
