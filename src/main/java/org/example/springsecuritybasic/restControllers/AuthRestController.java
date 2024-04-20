package org.example.springsecuritybasic.restControllers;


import lombok.RequiredArgsConstructor;
import org.example.springsecuritybasic.model.User;
import org.example.springsecuritybasic.model.dto.UserRequest;
import org.example.springsecuritybasic.model.dto.UserResponse;
import org.example.springsecuritybasic.service.UserService;
import org.example.springsecuritybasic.utils.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthRestController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<BaseResponse<UserResponse>> createNewUser(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.createUser(userRequest);
        BaseResponse<UserResponse> response = BaseResponse.createSuccess();
        response.setPayload(userResponse);
        return ResponseEntity.ok(response);
    }


}

