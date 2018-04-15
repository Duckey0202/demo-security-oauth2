package com.mt.demo.oauth2.service;

import com.alibaba.fastjson.JSONObject;
import com.mt.demo.oauth2.entity.RoleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * UserRoleServices
 *
 * @author MT.LUO
 * 2018/1/9 23:15
 * @Description:
 */
public interface RoleService extends BaseService<RoleEntity, Long> {

    List<RoleEntity> findDynamicParam(String key);

    RoleEntity findByRoleName(String name);

    Page<RoleEntity> findAll(JSONObject object, Pageable pageable);


    void deleteRoleToMenu(Long roleId);
}
