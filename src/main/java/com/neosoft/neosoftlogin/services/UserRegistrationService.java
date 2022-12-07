package com.neosoft.neosoftlogin.services;




import com.neosoft.neosoftlogin.core.entity.User;
import com.neosoft.neosoftlogin.core.reposatory.UserReposatory;
import com.neosoft.neosoftlogin.dto.LoginRequestDto;
import com.neosoft.neosoftlogin.dto.UserRegistrationRequestDto;
import com.neosoft.neosoftlogin.dto.UserRegistrationResponseDto;
import com.neosoft.neosoftlogin.exceptionHandler.UnAuthorizedException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Service
public class UserRegistrationService {

    @Autowired
    UserReposatory userReposatory;


    public void saverUserRegistrationDetails(UserRegistrationRequestDto userRegistrationRequestDto) {
            userValidation(userRegistrationRequestDto);
            User user = new User();
            user = getUser(user, userRegistrationRequestDto);
            userReposatory.save(user);


    }

    private void userValidation(UserRegistrationRequestDto userRegistrationRequestDto){
        User oldUser = userReposatory.findByMobileNoAndEmailId(userRegistrationRequestDto.getMobileNo(), userRegistrationRequestDto.getEmailId());
        if(oldUser != null){
            throw new ValidationException("User is already present with this mobile number"
                    + userRegistrationRequestDto.getMobileNo() + "or email" + userRegistrationRequestDto.getEmailId());
        }
    }

    private User getUser(User user , UserRegistrationRequestDto userRegistrationRequestDto){

        user.setEmailId(userRegistrationRequestDto.getEmailId());
        user.setPassword(userRegistrationRequestDto.getPassword());
        user.setConfirmPassword(userRegistrationRequestDto.getConfirmPassword());
        user.setFullName(userRegistrationRequestDto.getFullName());
        user.setCountry(userRegistrationRequestDto.getCountry());
        user.setState(userRegistrationRequestDto.getState());
        user.setDistrict(userRegistrationRequestDto.getDistrict());
        user.setPincode(userRegistrationRequestDto.getPincode());
        user.setAadharCard(userRegistrationRequestDto.getAadharCard());
        user.setPanCard(userRegistrationRequestDto.getPanCard());
        user.setCity(userRegistrationRequestDto.getCity());
        user.setMobileNo(userRegistrationRequestDto.getMobileNo());
        user.setUserType(userRegistrationRequestDto.getUserType());
        user.setActiveStatus(true);
        return user;
    }

    private UserRegistrationResponseDto getUserResponse( UserRegistrationResponseDto userRegistrationResponseDto, User user){
        userRegistrationResponseDto.setEmailId(user.getEmailId());
        userRegistrationResponseDto.setPassword(user.getPassword());
        userRegistrationResponseDto.setConfirmPassword(user.getConfirmPassword());
        userRegistrationResponseDto.setFullName(user.getFullName());
        userRegistrationResponseDto.setCountry(user.getCountry());
        userRegistrationResponseDto.setState(user.getState());
        userRegistrationResponseDto.setDistrict(user.getDistrict());
        userRegistrationResponseDto.setPincode(user.getPincode());
        userRegistrationResponseDto.setAadharCard(user.getAadharCard());
        userRegistrationResponseDto.setPanCard(user.getPanCard());
        userRegistrationResponseDto.setCity(user.getCity());
        userRegistrationResponseDto.setMobileNo(user.getMobileNo());
        userRegistrationResponseDto.setUserType(user.getUserType());
        userRegistrationResponseDto.setActiveStatus(user.isActiveStatus());
        return  userRegistrationResponseDto;
    }

    public void updateUserDetails(Long userId, UserRegistrationRequestDto userRegistrationRequestDto) {
       // userValidation(userRegistrationRequestDto);
        User user = userReposatory.findByUserId(userId);
        if(Objects.isNull(user)){
            throw new EntityNotFoundException("User is not Available for the user id :" + userId);
        }
        user = getUser(user , userRegistrationRequestDto);
        userReposatory.save(user);

    }

    public UserRegistrationResponseDto getUserDetailsByMobile(@NotNull String mobileNo) {
        User user = userReposatory.findByMobileNo(mobileNo);
        if(Objects.isNull(user)){
            throw new EntityNotFoundException("User is not found with the mobile number :" + mobileNo);
        }
        UserRegistrationResponseDto userRegistrationResponseDto = new UserRegistrationResponseDto();
        userRegistrationResponseDto = getUserResponse(userRegistrationResponseDto, user);

        return userRegistrationResponseDto;
    }

    public UserRegistrationResponseDto getUserDetailsByEmail(@NotNull String emailId) {
        User user = userReposatory.findByEmailId(emailId);
        if(Objects.isNull(user) || (Objects.nonNull(user) && !user.isActiveStatus())){
            throw new EntityNotFoundException("User is not found with the email id :" + emailId);
        }
        UserRegistrationResponseDto userRegistrationResponseDto = new UserRegistrationResponseDto();

       userRegistrationResponseDto = getUserResponse(userRegistrationResponseDto, user);

        return userRegistrationResponseDto;
    }

    public void deleteUser(Long userId) {
        User user = userReposatory.findByUserId(userId);
        if(user == null){
            throw new EntityNotFoundException("User is not Available for the user id :" + userId);
        }
        user.setActiveStatus(false);
        userReposatory.save(user);
    }

    public void activateUser(Long userId) {
        User user = userReposatory.findByUserId(userId);
        if(user == null){
            throw new EntityNotFoundException("User is not Available for the user id :" + userId);
        }
        user.setActiveStatus(true);
        userReposatory.save(user);
    }

    public User loginUser(LoginRequestDto loginRequestDto) {
        if(StringUtils.isBlank(loginRequestDto.getMobileNo())  && StringUtils.isBlank(loginRequestDto.getEmailId())){
            throw new ValidationException("invalid request for login");
        }
        User user = null;
        if(StringUtils.isNoneBlank(loginRequestDto.getMobileNo())){
            user = userReposatory.findByMobileNoAndPassword(loginRequestDto.getMobileNo(), loginRequestDto.getPassword());
        }else{
            user = userReposatory.findByEmailIdAndPassword(loginRequestDto.getEmailId(), loginRequestDto.getPassword());
        }
        if(user == null){
            throw new UnAuthorizedException(" Unauthorized user for login", HttpStatus.UNAUTHORIZED);
        }
        return user;

    }

    public List<User> getAllUser(boolean flag) {
       return userReposatory.findByActiveStatus(flag);
    }

    public User getUserById(Long userId) {
        return userReposatory.findByUserId(userId);
    }
}
