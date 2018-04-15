package com.mt.demo.oauth2.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * RegisterEntity
 *
 * @author MT.LUO
 * 2018/4/10 17:39
 * @Description:
 */
@Data
public class RegisterEntity {
    @NotNull(message = "userName not null")
    @Length(max = 32, message = "userName too long!!!")
    private String userName;

    @NotNull(message = "userPassword not null")
    @Length(max = 128, message = "userPassword too long!!!")
    private String userPassword;

    @NotNull(message = "userPhone not null")
    @Length(max = 11, message = "userPhone too long!!!")
    private String userPhone;

    @Length(max = 128, message = "userMail too long!!!")
    private String userMail;

    @NotNull(message = "userType not null")
    private int userType;

    @Length(max = 128, message = "userCompany too long!!!")
    private String userCompany;

    @Length(max = 255, message = "userAddr too long!!!")
    private String userAddr;

    @Length(max = 16, message = "userCity too long!!!")
    private String userCity;
    
    @Length(max = 16, message = "userProvince too long!!!")
    private String userProvince;
}
