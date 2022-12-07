package com.neosoft.neosoftlogin.controller;


import com.neosoft.neosoftlogin.core.entity.User;
import com.neosoft.neosoftlogin.dto.LoginRequestDto;
import com.neosoft.neosoftlogin.services.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserLoginController {

    @Autowired
    UserRegistrationService userRegistrationService;

    @PutMapping(value = "/user/login")
    public User loginUser( @RequestBody LoginRequestDto loginRequestDto){
       return userRegistrationService.loginUser(loginRequestDto);
    }

}
