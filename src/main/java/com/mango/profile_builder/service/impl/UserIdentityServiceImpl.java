package com.mango.profile_builder.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mango.profile_builder.exception.InvalidPasswordException;
import com.mango.profile_builder.exception.UserNotFoundException;
import com.mango.profile_builder.model.UserIdentity;
import com.mango.profile_builder.repository.UserIdentityRepository;
import com.mango.profile_builder.service.UserIdentityService;

@Service
public class UserIdentityServiceImpl implements UserIdentityService {

    @Autowired
    private UserIdentityRepository userIdentityRepository;

    public String authonticateUser(UserIdentity userIdentity) {
        Optional<UserIdentity> data = userIdentityRepository.findById(userIdentity.getUserName());
        if(!data.isPresent()){
             throw new UserNotFoundException("Invalid user name");
        }
        if(!userIdentity.getPassword().equals(data.get().getPassword())){
             throw new InvalidPasswordException("Invalid password");
        }
        return userIdentity.getUserName();
    }

    public void createUser(UserIdentity userIdentity) {
        System.out.println("service" + userIdentity);
        Optional<UserIdentity> data = userIdentityRepository.findById(userIdentity.getUserName());
        System.out.println("service - data from DB" + data);
        if(data.isPresent()){
            throw new UserNotFoundException("User already exist");
       }
       System.out.println("service - saved");
       userIdentityRepository.save(userIdentity);
    }

    public void updatePassword(UserIdentity userIdentity) {
        Optional<UserIdentity> data = userIdentityRepository.findById(userIdentity.getUserName());
        if(!data.isPresent()){
            throw new UserNotFoundException("Invalid user name");
       }
       userIdentityRepository.deleteById(userIdentity.getUserName());
       userIdentityRepository.save(userIdentity);
    }

    public void deleteUser(String userName) {
        userIdentityRepository.deleteById(userName);
    }
}
