package com.mt.demo.oauth2.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "nb_user")
public class UserEntity extends BaseEntity<UserEntity> {

    @NotNull(message = "username not null")
    @Pattern(regexp = "^[\\u4E00-\\u9FA5A-Za-z0-9]+$", message = "用户名为中文，英文，数字")
    @Length(max = 32, message = "username  too long")
    @Column(name = "user_name", length = 32)
    protected String userName;

    @Length(max = 60, message = "password too long")
    @Column(name = "user_password", length = 60)
    protected String userPassword;

    @Column(name = "user_phone", length = 16)
    @Length(max = 16, message = "phone too long")
    protected String userPhone;
    @Column(name = "user_remark", length = 128)
    @Length(max = 128, message = "remark too long")
    protected String userRemark;

    @ManyToMany(fetch = FetchType.EAGER)
    protected List<RoleEntity> roles;


    @Column(name = "user_mail", length = 128)
    @Length(max = 128, message = "user_mail too long")
    protected String userMail;

}
