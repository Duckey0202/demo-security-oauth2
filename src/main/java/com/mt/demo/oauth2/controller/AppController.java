package com.mt.demo.oauth2.controller;

import com.alibaba.fastjson.JSONObject;
import com.mt.demo.oauth2.entity.RegisterEntity;
import com.mt.demo.oauth2.entity.RoleEntity;
import com.mt.demo.oauth2.entity.UserEntity;
import com.mt.demo.oauth2.service.UserService;
import com.mt.demo.oauth2.utils.Constant;
import com.mt.demo.oauth2.utils.ResultCode;
import com.mt.demo.oauth2.utils.ResultModel;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * AppController
 *
 * @author MT.LUO
 * 2018/4/10 17:18
 * @Description:
 */
@CrossOrigin
@RestController
@RequestMapping("/iot/app/v100/app/accounts")
public class AppController {
    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public ResultModel register(@Valid @RequestBody RegisterEntity registerEntity, BindingResult result) {
        if (result.hasErrors()) {
            return ResultModel.error(result, messageSource);
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(registerEntity.getUserName());
        userEntity.setUserPassword(registerEntity.getUserPassword());
        userEntity.setUserPhone(registerEntity.getUserPhone());
        userEntity.setUserMail(registerEntity.getUserMail());
        userEntity.setActionId(0l);
        List<RoleEntity> roleEntities = new ArrayList<>();
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(2l);
        roleEntities.add(roleEntity);
        userEntity.setRoles(roleEntities);
        JSONObject object = new JSONObject();
        if (registerEntity.getUserType() == 0) {
            object.put("companyName", "PERSONAL-" + userEntity.getUserName());
            object.put("addr", registerEntity.getUserAddr());
            object.put("city", registerEntity.getUserCity());
            object.put("province", registerEntity.getUserProvince());
        } else {
            object.put("companyName", registerEntity.getUserCompany());
            object.put("addr", registerEntity.getUserAddr());
            object.put("city", registerEntity.getUserCity());
            object.put("province", registerEntity.getUserProvince());
        }
        userService.save(userEntity, Constant.ACTION_FLAG_INSERT);
        return ResultModel.ok("success");
    }

    @RequestMapping(value = "/username", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public ResultModel usernameValid(@NotNull(message = "username is not null") @Length(max = 32, message =
            "username" + " too long") @RequestBody String username, BindingResult result) {
        if (result.hasErrors()) {
            return ResultModel.error(result, messageSource);
        }

        if (userService.nameExsit(username)) {
            return ResultModel.error(ResultCode.RESULT_CODE_USERNAME_EXIST, "用户名已存在");
        }
        return ResultModel.ok("success");
    }

    @RequestMapping(value = "/authcode", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public ResultModel authcode(@NotNull(message = "userPhone is not null") @Length(max = 11, message =
            "userPhone too long") @RequestBody String userPhone, BindingResult result) {
        if (result.hasErrors()) {
            return ResultModel.error(result, messageSource);
        }

        if (userService.userPhoneExsit(userPhone)) {
            return ResultModel.error(ResultCode.RESULT_CODE_USERNAME_EXIST, "该手机号已注册");
        }
        return ResultModel.ok("success");
    }

    @RequestMapping(value = "/authcode/valid", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public ResultModel authcodeValid(@RequestBody JSONObject object, BindingResult result) {
        if (result.hasErrors()) {
            return ResultModel.error(result, messageSource);
        }

        return ResultModel.ok("success");
    }
}
