package com.mt.demo.oauth2.repository;

import com.mt.demo.oauth2.entity.RoleToMenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * RoleToMenuRepository
 *
 * @author MT.LUO
 * 2018/3/29 0:22
 * @Description:
 */
public interface RoleToMenuRepository extends JpaRepository<RoleToMenuEntity, Long>,
        JpaSpecificationExecutor<RoleToMenuEntity>, Serializable {

    @Transactional
    void deleteAllByRolesId(Long rid);
}
