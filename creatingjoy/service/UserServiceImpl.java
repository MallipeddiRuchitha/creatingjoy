package com.technocrats.creatingjoy.service;

import com.technocrats.creatingjoy.dao.RoleRepository;
import com.technocrats.creatingjoy.dao.UserRepository;
import com.technocrats.creatingjoy.dto.UserDTO;
import com.technocrats.creatingjoy.entity.Role;
import com.technocrats.creatingjoy.entity.User;
import com.technocrats.creatingjoy.objectmapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public List<User> findAll() {

        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User findById(int id) {

        Optional<User> result=userRepository.findById(id);

        if(result.isPresent()){
            return result.get();
        }
        else{
            throw new RuntimeException("Did not found User with id "+id);
        }


    }

    @Override
    @Transactional
    public User findByUserName(String userName) {
        // check the database if the user already exists
        return userRepository.findByUserName(userName);
    }

    @Override
    @Transactional
    public void save(UserDTO userDTO) {
User user= userMapper.convertToEntity(userDTO);


        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

    }

    @Override
    @Transactional
    public void deleteById(int id) {

        userRepository.deleteById(id);

    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
