package com.moneymatters.services;

import com.moneymatters.data.dtos.AuthDto;
import com.moneymatters.data.dtos.UserDto;
import com.moneymatters.data.mappers.UserDtoMapper;
import com.moneymatters.data.models.User;
import com.moneymatters.repositories.UserRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    private final UserRepository userRepository;
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, TokenService tokenService, @Lazy AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + email));
        return user;
    }

    public String signin(AuthDto authDto) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authDto.getEmail(),authDto.getPassword());

        Authentication authentication = authenticationManager.authenticate((usernamePasswordAuthenticationToken));

        User user = (User)authentication.getPrincipal();

        return tokenService.generateToken(user);
    }

    public String signup(UserDto userDto) {
        User user = userRepository.save(UserDtoMapper.INSTANCE.toUser(userDto));

        AuthDto authDto = new AuthDto(userDto.getEmail(), userDto.getPassword());

        return signin(authDto);
    }
}
