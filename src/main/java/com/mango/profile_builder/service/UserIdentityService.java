package com.mango.profile_builder.service;

import com.mango.profile_builder.model.UserIdentity;

public interface UserIdentityService {

String authonticateUser(UserIdentity userIdentity);
void createUser(UserIdentity userIdentity);
void updatePassword(UserIdentity userIdentity);
void deleteUser(String userName);
}
