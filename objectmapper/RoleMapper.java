package com.technocrats.creatingjoy.objectmapper;

import com.technocrats.creatingjoy.dto.RoleDTO;
import com.technocrats.creatingjoy.entity.Role;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    @Autowired
    private ModelMapper mapper;

    public RoleDTO convertToDto(Role theRole){

        RoleDTO theRoleDto=mapper.map(theRole,RoleDTO.class);
        return theRoleDto;

    }


    public Role convertToEntity(RoleDTO theRoleDto){

        Role theRole=mapper.map(theRoleDto,Role.class);
        return theRole;

    }
}
