package com.mark.restaurant.menu.api.services;


import com.mark.restaurant.menu.api.domain.User;
import com.mark.restaurant.menu.api.dto.AuthenticationDto;
import com.mark.restaurant.menu.api.dto.LoginResponseDto;
import com.mark.restaurant.menu.api.dto.RegisterDto;
import com.mark.restaurant.menu.api.repositories.UserRepository;
import com.mark.restaurant.menu.api.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    public LoginResponseDto login(AuthenticationDto data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());
        return new LoginResponseDto(token);
    }

    public void register(RegisterDto data) {
        if (this.userRepository.findByEmail(data.email()) != null) {
            throw new RuntimeException("User already exists");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User user = new User(data.email(), encryptedPassword, data.role());
        this.userRepository.save(user);
    }
}