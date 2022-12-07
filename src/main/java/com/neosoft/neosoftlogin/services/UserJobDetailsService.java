package com.neosoft.neosoftlogin.services;

import com.neosoft.neosoftlogin.core.entity.User;
import com.neosoft.neosoftlogin.core.entity.UserJobDetails;
import com.neosoft.neosoftlogin.core.reposatory.UserJobDetailsReposatory;
import com.neosoft.neosoftlogin.core.reposatory.UserReposatory;
import com.neosoft.neosoftlogin.dto.UserJobDetailsRequestDto;
import com.neosoft.neosoftlogin.dto.UserJobDetailsResponseDto;
import com.neosoft.neosoftlogin.dto.UserRegistrationResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
public class UserJobDetailsService {

    @Autowired
    UserReposatory userReposatory;

    @Autowired
    UserJobDetailsReposatory userJobDetailsReposatory;

    public void addUserDetails(Long id, UserJobDetailsRequestDto userJobDetailsRequestDto) {
        User user = userReposatory.findByUserIdAndActiveStatus(id, true);

        if(Objects.isNull(user)){
            throw new EntityNotFoundException("User is not found for user id " + id);

        }
        UserJobDetails userJobDetails = new UserJobDetails();
        userJobDetails.setUserId(user.getUserId());
        userJobDetails.setAchievements(userJobDetailsRequestDto.getAchievements());
        userJobDetails.setCompanyName(userJobDetailsRequestDto.getCompanyName());
        userJobDetails.setCtc(userJobDetailsRequestDto.getCtc());
        userJobDetails.setJoiningDate(userJobDetailsRequestDto.getJoiningDate());
        userJobDetails.setExitDate(userJobDetailsRequestDto.getExitDate());
        userJobDetails.setActiveStatus(true);
        userJobDetailsReposatory.save(userJobDetails);

    }

    public UserJobDetailsResponseDto getUserDetails(Long id) {
        UserJobDetails user = userJobDetailsReposatory.findByUserDetailsId(id);
        if(Objects.isNull(user) || (Objects.nonNull(user) && !user.isActiveStatus())){
            throw new EntityNotFoundException("User is not found with the email id :" + id);
        }
        UserJobDetailsResponseDto userJobDetailsResponseDto = new UserJobDetailsResponseDto();

        userJobDetailsResponseDto.setAchievements(user.getAchievements());
        userJobDetailsResponseDto.setActiveStatus(user.isActiveStatus());
        userJobDetailsResponseDto.setCompanyName(user.getCompanyName());
        userJobDetailsResponseDto.setCtc(user.getCtc());
        userJobDetailsResponseDto.setExitDate(user.getExitDate());
        userJobDetailsResponseDto.setJoiningDate(user.getJoiningDate());
        userJobDetailsResponseDto.setUserId(user.getUserId());
        userJobDetailsResponseDto.setUserDetailsId(user.getUserDetailsId());

        return userJobDetailsResponseDto;

    }

    public List<UserJobDetails> getUserDetailsById(Long userId) {
        return userJobDetailsReposatory.findByUserIdAndActiveStatus(userId,true);
    }

    public void deleteUser(Long userDetailsId) {
        UserJobDetails userJobDetails = userJobDetailsReposatory.findByUserDetailsId(userDetailsId);
        if(userJobDetails == null){
            throw new EntityNotFoundException("Job Details is not Available for the Job id :" + userDetailsId);
        }
        userJobDetails.setActiveStatus(false);
        userJobDetailsReposatory.save(userJobDetails);

    }
}
