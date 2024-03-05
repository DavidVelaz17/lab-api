package com.lab.labeli.services;

import com.lab.labeli.repository.UserRepository;
import com.lab.labeli.requests.LoginRequest;
import com.lab.labeli.responses.AuthResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    //@Value("${not.found}")
    //private String notFound;

    public AuthResponse login(LoginRequest request) throws Exception {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getName(),request.getPassword()));
        validateUserIfExists(request.getName());
        UserDetails user = userRepository.findByName(request.getName());
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }
    private void validateUserIfExists(final String name) throws Exception {
        if (userRepository.findByName(name) == null) {
            throw new Exception("Not found");
        }
    }
}
