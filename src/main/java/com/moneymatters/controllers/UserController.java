package com.moneymatters.controllers;

import com.moneymatters.data.dtos.UserDto;
import com.moneymatters.data.models.User;
import com.moneymatters.services.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @GetMapping("/page")
    public Page<User> findAllPaged(@RequestParam(required = false) String username,
                                   @RequestParam(required = false) String email, Pageable pageable) {
        return userService.findAllPaged(username, email, pageable);
    }

    @PostMapping
    public User store(@Valid @RequestBody UserDto userdto) {
        return userService.store(userdto);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable("id") Long id, @Valid @RequestBody UserDto userDto) {
        return userService.update(id, userDto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "Successfully deleted user";
    }

    @GetMapping("/user-comparison-month-over-month")
    public Integer userComparisonMonthOverMonth() {
        return userService.userComparisonMonthOverMonth();
    }

}