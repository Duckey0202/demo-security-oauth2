package com.mt.demo.oauth2.controller;

import com.alibaba.fastjson.JSONObject;
import com.mt.demo.oauth2.entity.RegisterEntity;
import com.mt.demo.oauth2.entity.RoleEntity;
import com.mt.demo.oauth2.entity.UserEntity;
import com.mt.demo.oauth2.service.UserService;
import com.mt.demo.oauth2.utils.Constant;
import com.mt.demo.oauth2.utils.LogController;
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
@RequestMapping("/iot/app")
public class TestController {
    @RequestMapping(value = "/test", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public ResultModel register() {
        LogController.info("TestController", "aaaaaaaaaaaaaa");
        return ResultModel.ok("success");
    }
}
