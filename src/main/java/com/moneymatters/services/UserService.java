package com.moneymatters.services;

import com.moneymatters.data.dtos.UserDto;
import com.moneymatters.data.models.User;
import com.moneymatters.repositories.UserRepository;
import com.moneymatters.services.exceptions.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
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

    public void delete(Long id) {
        User user = findById(id);
        userRepository.delete(user);
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

    public Page<User> findAllPaged(String username, String email, Pageable pageable) {
        if (null != username && !username.isEmpty()) {
            return findByUsernamePaged(username, pageable);
        } else if (null != email && !email.isEmpty()) {
            return findByEmailPaged(email, pageable);
        }
        return userRepository.findAll(pageable);
    }

    private Page<User> findByUsernamePaged(String username, Pageable pageable) {
        return userRepository.findByUsername(username, pageable);
    }

    private Page<User> findByEmailPaged(String email, Pageable pageable) {
        return userRepository.findByEmail(email, pageable);
    }

    public Integer userComparisonMonthOverMonth() {
        String[] countUsers = userRepository.usersFromMonth().split(",");

        Integer countUsersCurrentMonth = Integer.parseInt(countUsers[0]);
        Integer countUsersLastMonth = Integer.parseInt(countUsers[1]);

        return countUsersCurrentMonth - countUsersLastMonth;
    }
}