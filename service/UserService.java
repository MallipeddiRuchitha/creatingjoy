package com.technocrats.creatingjoy.service;

import com.technocrats.creatingjoy.dto.UserDTO;

import java.util.List;

public interface UserService{

    List<UserDTO> findAll();
    UserDTO findById(int id);
    void save(UserDTO user);
    void deleteById(int id);
    UserDTO findByUserName(String userName);



}
