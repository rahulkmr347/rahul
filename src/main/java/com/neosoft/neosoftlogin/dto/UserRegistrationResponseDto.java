package com.neosoft.neosoftlogin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class UserRegistrationResponseDto {
    private String emailId;
    private String password;
    private String confirmPassword;
    private String fullName;
    private String country;
    private String state;
    private String district;
    private Integer pincode;
    private Long aadharCard;
    private String panCard;
    private String city;
    private String mobileNo;
    private String userType;
    private boolean activeStatus;
}
