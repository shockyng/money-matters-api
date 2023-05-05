package com.moneymatters.controllers;

import com.moneymatters.dtos.UserDto;
import com.moneymatters.models.User;
import com.moneymatters.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public User store(@RequestBody UserDto userdto) {
        return userService.store(userdto);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        return userService.update(id, userDto);
    }

}
