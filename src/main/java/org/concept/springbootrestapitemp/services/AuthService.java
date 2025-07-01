package org.concept.springbootrestapitemp.services;

import jakarta.persistence.EntityNotFoundException;
import org.concept.springbootrestapitemp.config.JwtService;
import org.concept.springbootrestapitemp.dtos.requests.LoginRequest;
import org.concept.springbootrestapitemp.dtos.requests.RegisterRequest;
import org.concept.springbootrestapitemp.repositories.UserRepository;
import org.concept.springbootrestapitemp.models.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder bcryptPasswordEncoder;

    public AuthService(UserRepository userRepository,
                       AuthenticationManager authenticationManager,
                       JwtService jwtService,
                       BCryptPasswordEncoder bcryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.bcryptPasswordEncoder = bcryptPasswordEncoder;
    }

    public User register(RegisterRequest registerRequest) {
        User user = new User(
            registerRequest.getEmail(),
            bcryptPasswordEncoder.encode(registerRequest.getPassword()),
            registerRequest.getFirstName(),
            registerRequest.getLastName()
        );
        return userRepository.save(user); // Refactor to response object
    }

    public String login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        ));

        User user = userRepository.findByEmail(loginRequest.getEmail())
            .orElseThrow(() -> new EntityNotFoundException("User not found"));
        return jwtService.generateToken(user);
    }
}
