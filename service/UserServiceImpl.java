package com.technocrats.creatingjoy.service;

import com.technocrats.creatingjoy.dao.UserRepository;
import com.technocrats.creatingjoy.dto.UserDTO;
import com.technocrats.creatingjoy.entity.User;
import com.technocrats.creatingjoy.objectmapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public List<UserDTO> findAll() {

        List<User> allUsers = new ArrayList<>();
        allUsers = userRepository.findAll();
        List<UserDTO> allUsersDto = new ArrayList<>();
        for(User user: allUsers)
            allUsersDto.add(userMapper.convertToDto(user));

        return allUsersDto;
    }

    @Override
    public UserDTO findById(int id) {

        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            UserDTO userDto = userMapper.convertToDto(user.get());
            return userDto;
        }
        else
            throw new RuntimeException("User not found :" + id);
    }

    @Override
    public void save(UserDTO userDto) {
        String encryptedPassword = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(encryptedPassword);
        User user = userMapper.convertToEntity(userDto);
        userRepository.save(user);
    }

    @Override
    public void deleteById(int id) {
        if(id>0)
            userRepository.deleteById(id);
    }


    public UserDTO findByUserName(String userName) {
        // check the database if the user already exists
        User user =  userRepository.findByUserName(userName);
        UserDTO userDto = null;
        if(user!=null)
            userDto = userMapper.convertToDto(user);
        return userDto;

    }


}
