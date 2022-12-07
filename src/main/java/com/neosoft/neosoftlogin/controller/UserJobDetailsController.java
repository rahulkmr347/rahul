package com.neosoft.neosoftlogin.controller;


import com.neosoft.neosoftlogin.core.entity.UserJobDetails;
import com.neosoft.neosoftlogin.dto.UserJobDetailsRequestDto;
import com.neosoft.neosoftlogin.dto.UserJobDetailsResponseDto;
import com.neosoft.neosoftlogin.services.UserJobDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/details")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserJobDetailsController {

    @Autowired
    UserJobDetailsService userDetailsService;

    @PostMapping(value = "/add-detail/{id}")
    public void addUserDetails(@PathVariable(name = "id") Long id , @RequestBody UserJobDetailsRequestDto userJobDetailsRequestDto){
        userDetailsService.addUserDetails(id, userJobDetailsRequestDto);
    }

    @GetMapping(value = "/user-details/{id}")
    public UserJobDetailsResponseDto getUserDetails(@PathVariable(name = "id") Long id){
        return userDetailsService.getUserDetails(id);
    }

    @GetMapping(value = "/all-user-details/{userId}")
    public List<UserJobDetails> getUserDetailById(@PathVariable(name = "userId")Long userId){
        return userDetailsService.getUserDetailsById(userId);
    }

    @DeleteMapping(value = "/user-delete/delete/{userDetailsId}")
    public void deleteUser(@PathVariable(name = "userDetailsId") Long userDetailsId){
        userDetailsService.deleteUser(userDetailsId);

    }
}
