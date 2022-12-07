package com.neosoft.neosoftlogin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class UserJobDetailsResponseDto {

    private String companyName;
    private Date joiningDate;
    private Date exitDate;
    private String achievements;
    private String ctc;
    private boolean activeStatus;
    private Long userId;
    private Long userDetailsId;
}
