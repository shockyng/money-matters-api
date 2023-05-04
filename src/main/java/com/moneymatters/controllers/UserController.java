package com.moneymatters.controllers;

import com.moneymatters.dtos.UserDto;
import com.moneymatters.models.User;
import com.moneymatters.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User storeUser(@RequestBody UserDto userdto) {
        return userService.storeUser(userdto);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        return userService.updateUser(id, userDto);
    }

}
