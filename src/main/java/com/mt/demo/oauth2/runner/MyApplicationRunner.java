package com.mt.demo.oauth2.runner;

import com.mt.demo.oauth2.entity.RoleEntity;
import com.mt.demo.oauth2.manager.RoleManager;
import com.mt.demo.oauth2.utils.LogController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * MyApplicationRunner
 *
 * @author MT.LUO
 * 2018/1/18 14:04
 * @Description:
 */
@Component
@Order(value = 1)
public class MyApplicationRunner implements ApplicationRunner {

    @Autowired
    private RoleManager roleManager;


    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        LogController.info("MyApplicationRunner", "run....");
        RoleEntity roleEntity = roleManager.findOne(2l);

        /**
         * create role for mobile user
         * */
        if (roleEntity == null) {
            roleEntity = new RoleEntity();
            roleEntity.setId(2l);
            roleEntity.setRoleName("ROLE_MOBILE");
            roleEntity.setActionId(0l);
            roleManager.save(roleEntity);
        } else if (roleEntity.getRoleName().equals("ROLE_MOBILE")) {
            roleEntity.setRoleName("ROLE_MOBILE");
            roleManager.save(roleEntity);
        }
    }
}
