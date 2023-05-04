package com.moneymatters.services;

import com.moneymatters.dtos.UserDto;
import com.moneymatters.models.User;
import com.moneymatters.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    public ArrayList<User> getAllUsers() {
        return (ArrayList<User>) userRepository.findAll();
    }

    public User storeUser(UserDto userDto) {
        User user = createUserReceivingDto(userDto);
        return userRepository.save(user);
    }

    public User updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id).get();
        user.setUsername(userDto.getUsername());
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        return user;
    }

    private User createUserReceivingDto(UserDto userDto) {
        User user = new User();

        user.setUsername(userDto.getUsername());
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        return user;
    }

}
