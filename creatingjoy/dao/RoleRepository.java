package com.technocrats.creatingjoy.dao;

import com.technocrats.creatingjoy.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    Role findRoleByName(String roleName);
}