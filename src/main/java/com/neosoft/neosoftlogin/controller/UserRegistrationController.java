package com.neosoft.neosoftlogin.controller;


import com.neosoft.neosoftlogin.core.entity.User;
import com.neosoft.neosoftlogin.dto.UserRegistrationRequestDto;
import com.neosoft.neosoftlogin.dto.UserRegistrationResponseDto;
import com.neosoft.neosoftlogin.services.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/registration")
@CrossOrigin(origins = "http://localhost:4200/")
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

    @GetMapping(value = "all/user")
    public List<User> getAllUser(){
        return userRegistrationService.getAllUser(true);
    }

    @GetMapping(value = "all/user/getDeleted")
    public List<User> getAllDeletedUser(){
        return userRegistrationService.getAllUser(false);
    }

    @GetMapping(value = "find/{userId}")
    public User getUserById(@PathVariable(name = "userId") Long userId){
        return userRegistrationService.getUserById(userId);
    }

    @GetMapping(value = "user/activate/{userId}")
    public void activateUser(@PathVariable(name = "userId") Long userId){
        userRegistrationService.activateUser(userId);

    }
}
