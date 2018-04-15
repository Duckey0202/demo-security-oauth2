package com.mt.demo.oauth2.repository;

import com.mt.demo.oauth2.entity.RoleEntity;

public interface RoleRepository extends BaseRepository<RoleEntity, Long> {

    RoleEntity findByRoleName(String name);

}
