package com.mt.demo.oauth2.repository;

import com.mt.demo.oauth2.entity.UserEntity;

public interface UserRepository extends BaseRepository<UserEntity, Long> {

    UserEntity findByUserName(String name);

    UserEntity findByIdAndUserPassword(Long id, String pwd);

    UserEntity findByUserPhone(int phone);
}
