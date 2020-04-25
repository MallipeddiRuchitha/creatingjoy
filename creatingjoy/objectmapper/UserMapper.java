package com.technocrats.creatingjoy.objectmapper;


import com.technocrats.creatingjoy.dto.UserDTO;
import com.technocrats.creatingjoy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

@Component
public class UserMapper {
    @Autowired
    private ModelMapper mapper;

    public UserDTO convertToDto(User theUser){

        UserDTO theUserDto=mapper.map(theUser,UserDTO.class);
        return theUserDto;

    }


    public User convertToEntity(UserDTO theUserDto){

        User theUser=mapper.map(theUserDto,User.class);
        return theUser;

    }
}
