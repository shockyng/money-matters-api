package com.moneymatters.controllers;

import com.moneymatters.data.dtos.AuthDto;
import com.moneymatters.data.dtos.UserDto;
import com.moneymatters.data.models.User;
import com.moneymatters.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signin")
    public String signin(@RequestBody AuthDto authDto) {
        return authService.signin(authDto);
    }

    @PostMapping("/signup")
    public String signup(@Valid @RequestBody UserDto userDto) {
        return authService.signup(userDto);
    }

}
