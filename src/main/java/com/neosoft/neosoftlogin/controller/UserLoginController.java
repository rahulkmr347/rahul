package com.neosoft.neosoftlogin.controller;


import com.neosoft.neosoftlogin.core.entity.User;
import com.neosoft.neosoftlogin.dto.LoginRequestDto;
import com.neosoft.neosoftlogin.services.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class UserLoginController {

    @Autowired
    UserRegistrationService userRegistrationService;

    @PutMapping(value = "/user/login")
    public User loginUser( @RequestBody LoginRequestDto loginRequestDto){
       return userRegistrationService.loginUser(loginRequestDto);
    }

}
