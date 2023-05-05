package com.moneymatters.services;

import com.moneymatters.dtos.UserDto;
import com.moneymatters.models.User;
import com.moneymatters.repositories.UserRepository;
import com.moneymatters.services.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id) );
    }

    public User store(UserDto userDto) {
        User user = createUserReceivingDto(userDto);
        return userRepository.save(user);
    }

    public User update(Long id, UserDto userDto) {
        User user = findById(id);

        user.setUsername(userDto.getUsername());
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setEmail(userDto.getEmail());

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
