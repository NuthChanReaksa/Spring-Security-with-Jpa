package org.example.springsecuritybasic.service;

import org.example.springsecuritybasic.model.dto.UserRequest;
import org.example.springsecuritybasic.model.dto.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);
}
