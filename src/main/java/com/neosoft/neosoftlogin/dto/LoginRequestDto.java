package com.neosoft.neosoftlogin.dto;

import com.neosoft.neosoftlogin.utils.RegexFormats;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Setter
@Getter
@ToString
public class LoginRequestDto {

    @Pattern(regexp = RegexFormats.MOBILE, message = "invalid mobile number")
    private String mobileNo;
    @Pattern(regexp = RegexFormats.EMAIL, message = "invalid email")
    private String emailId;
    @NotEmpty(message = "Password can not be empty")
    private String password;
}
