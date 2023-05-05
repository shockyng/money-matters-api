package com.moneymatters.services;

import com.moneymatters.dtos.UserDto;
import com.moneymatters.models.User;
import com.moneymatters.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id).get();
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

        return userRepository.save(user);
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
