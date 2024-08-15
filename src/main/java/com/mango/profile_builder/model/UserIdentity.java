package com.mango.profile_builder.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usersIdentity")
public class UserIdentity {

    @Id
    private String userName;
    private String password;

    public UserIdentity(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public UserIdentity() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "UserIdentity [userName=" + userName + ", password=" + password + "]";
    }

}
