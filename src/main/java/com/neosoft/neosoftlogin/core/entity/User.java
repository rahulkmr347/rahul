package com.neosoft.neosoftlogin.core.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "USER")
@Setter @Getter @ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "EMAIL_ID")
    private String emailId;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "CONFIRM_PASSWORD")
    private String confirmPassword;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "STATE")
    private String state;

    @Column(name = "DISTRICT")
    private String district;

    @Column(name = "PINCODE")
    private Integer pincode;

    @Column(name = "AADHAR_CARD")
    private Long aadharCard;

    @Column(name = "PAN_CARD")
    private String panCard;

    @Column(name = "CITY")
    private String city;

    @Column(name = "MOBILE_NO")
    private String mobileNo;

    @Column(name = "USER_TYPE")
    private String userType;

    @Column(name = "ACTIVE_STATUS")
    private boolean activeStatus;
}
