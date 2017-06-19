package com.mukund.restcaller.vo;

/**
 * Created by mukund on 6/18/17.
 */

public class UserDetailsVO {

    private String userId;
    private String password;
    private String userType;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
