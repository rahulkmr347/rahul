package com.neosoft.neosoftlogin.services;

import com.neosoft.neosoftlogin.core.reposatory.UserReposatory;
import com.neosoft.neosoftlogin.dto.UserJobDetailsRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {

    @Autowired
    UserReposatory userReposatory;

    public void addUserDetails(Long id, UserJobDetailsRequestDto userJobDetailsRequestDto) {
        userReposatory.findByUserId(id);

    }
}
