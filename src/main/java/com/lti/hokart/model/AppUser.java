package com.lti.hokart.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "app_user")
public class AppUser {
    @Id
    @GenericGenerator(name = "appuser_sequence", strategy = "increment")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appuser_sequence")
    @Column(name = "app_user_id")
    private int appUserId; // PK

    @Column(name = "app_user_name")
    private String appUserName;

    @Column(name = "app_user_is_seller")
    private boolean appUserisSeller;

    public AppUser(int appUserId, String appUserName, boolean appUserisSeller) {
        super();
        this.appUserId = appUserId;
        this.appUserName = appUserName;
        this.appUserisSeller = appUserisSeller;
    }

    public AppUser() {
        super();
    }

    public int getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(int appUserId) {
        this.appUserId = appUserId;
    }

    public String getAppUserName() {
        return appUserName;
    }

    public void setAppUserName(String appUserName) {
        this.appUserName = appUserName;
    }

    public boolean isAppUserisSeller() {
        return appUserisSeller;
    }

    public void setAppUserisSeller(boolean appUserisSeller) {
        this.appUserisSeller = appUserisSeller;
    }
}
