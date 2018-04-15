package com.mt.demo.oauth2.manager;

import com.alibaba.fastjson.JSONObject;
import com.github.wenhao.jpa.Specifications;
import com.mt.demo.oauth2.entity.RoleEntity;
import com.mt.demo.oauth2.entity.RoleToMenuEntity;
import com.mt.demo.oauth2.repository.RoleRepository;
import com.mt.demo.oauth2.repository.RoleToMenuRepository;
import com.mt.demo.oauth2.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * UserRoleManager
 *
 * @author MT.LUO
 * 2018/1/9 23:15
 * @Description:
 */
@Service
public class RoleManager extends BaseManager<RoleEntity, Long> implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleToMenuRepository roleToMenuRepository;


    @Override
    public List<RoleEntity> findDynamicParam(String key) {
        return null;
    }

    @Override
    public RoleEntity findByRoleName(String name) {
        return roleRepository.findByRoleName(name);
    }

    @Override
    public boolean nameExsit(String name) {
        if(roleRepository.findByRoleName(name) == null){
            return false;
        }
        return true;
    }
    @Override
    public Page<RoleEntity> findAll(JSONObject object, Pageable pageable) {
        String userName = "";
        if (object.containsKey("roleName")) {
            userName = object.getString("userName");
        }

        Specification<RoleEntity> specification = Specifications.<RoleEntity>and().eq("deleted", false).like(
                (!userName.equals("")), "role_name", userName).build();
        return roleRepository.findAll(specification, pageable);
    }


    @Override
    public void deleteRoleToMenu(Long roleId) {
        roleToMenuRepository.deleteAllByRolesId(roleId);
    }


}
