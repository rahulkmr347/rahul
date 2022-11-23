package com.neosoft.neosoftlogin.controller;


import com.neosoft.neosoftlogin.dto.UserRegistrationRequestDto;
import com.neosoft.neosoftlogin.dto.UserRegistrationResponseDto;
import com.neosoft.neosoftlogin.services.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    UserRegistrationService userRegistrationService;

    @PostMapping(value = "/user/register")
    public void saveUserRegistrationDetails(@RequestBody UserRegistrationRequestDto userRegistrationRequestDto){
        userRegistrationService.saverUserRegistrationDetails(userRegistrationRequestDto);
    }

    @PutMapping(value = "/user/{userId}")
    public void updateUserDetails(@PathVariable(name = "userId") Long userId, @RequestBody UserRegistrationRequestDto userRegistrationRequestDto){
        userRegistrationService.updateUserDetails(userId, userRegistrationRequestDto);
    }

    @GetMapping(value = "/user-by-mobile/{mobileNo}")
    public UserRegistrationResponseDto getUserDetailsByMobile(@NotNull @PathVariable(name = "mobileNo") String mobileNo){
        return  userRegistrationService.getUserDetailsByMobile(mobileNo);
    }

    @GetMapping(value = "/user-by-email/{emailId}")
    public UserRegistrationResponseDto getUserDetailsByEmail(@NotNull @PathVariable(name = "emailId") String emailId){
        return  userRegistrationService.getUserDetailsByEmail(emailId);
    }

    @DeleteMapping(value = "user/delete/{userId}")
    public void deleteUser(@PathVariable(name = "userId") Long userId){
        userRegistrationService.deleteUser(userId);

    }

    @RequestMapping(method = RequestMethod.HEAD, value = "head/{id}" )
    public ResponseEntity<String> head(){
        return ResponseEntity.ok("header");
    }
}
