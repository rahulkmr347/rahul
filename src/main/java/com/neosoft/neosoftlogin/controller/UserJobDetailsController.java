package com.neosoft.neosoftlogin.controller;


import com.neosoft.neosoftlogin.dto.UserJobDetailsRequestDto;
import com.neosoft.neosoftlogin.services.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/details")
public class UserJobDetailsController {

    @Autowired
    UserDetailsService userDetailsService;

    @PostMapping(value = "/add-detail")
    public void addUserDetails(@PathVariable(name = "id") Long id , @RequestBody UserJobDetailsRequestDto userJobDetailsRequestDto){
        userDetailsService.addUserDetails(id, userJobDetailsRequestDto);
    }
}
