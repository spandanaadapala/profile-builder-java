package com.mango.profile_builder.controller;

import org.springframework.web.bind.annotation.RestController;

import com.mango.profile_builder.model.UserIdentity;
import com.mango.profile_builder.service.UserIdentityService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class UserIdentityController {

    @Autowired
    private UserIdentityService userIdentityService;

    @PostMapping("/authonticateUser")
    public String postMethodName(@RequestBody UserIdentity userIdentity) {
        return userIdentityService.authonticateUser(userIdentity);
    }
    

    @PostMapping("/createUser")
    public void createUser(@RequestBody UserIdentity userIdentity) {
        System.out.println("controller" + userIdentity);
        userIdentityService.createUser(userIdentity);
    }

    @PutMapping("/updatePassword")
    public void updatePassword(@RequestBody UserIdentity userIdentity) {
        userIdentityService.updatePassword(userIdentity);
    }

    @DeleteMapping("/deleteUser/{userName}")
    public void deleteUser(@PathVariable String userName) {
        userIdentityService.deleteUser(userName);
    }
}
