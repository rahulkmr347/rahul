package com.neosoft.neosoftlogin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter @ToString
public class UserJobDetailsRequestDto {

    private String companyName;
    private Date joiningDate;
    private Date exitDate;
    private String achievements;
    private String ctc;
}
