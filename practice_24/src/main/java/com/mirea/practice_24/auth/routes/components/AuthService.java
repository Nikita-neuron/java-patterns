package com.mirea.practice_24.auth.routes.components;

import com.mirea.practice_24.auth.cookies.CookieEntity;
import com.mirea.practice_24.auth.cookies.CookieRepo;
import com.mirea.practice_24.auth.jwt.JwtService;
import com.mirea.practice_24.auth.routes.dto.AuthRequestDTO;
import com.mirea.practice_24.auth.routes.dto.AuthResponseDTO;
import com.mirea.practice_24.auth.routes.dto.RegisterRequestDTO;
import com.mirea.practice_24.users.User;
import com.mirea.practice_24.users.UserRepo;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;

    private final CookieRepo cookieRepo;

    public AuthResponseDTO register(RegisterRequestDTO requestData, HttpServletRequest request) {
        Optional<User> dbUser = userRepo.findByEmail(requestData.getEmail());
        if (dbUser.isPresent()) {
            return AuthResponseDTO.builder().jwt(null).status(409).build();
        }

        User user = User.builder()
                .name(requestData.getName())
                .email(requestData.getEmail())
                .password(passwordEncoder.encode(requestData.getPassword()))
                .build();

        userRepo.save(user);

        if (request != null) {
            for (Cookie cookie : request.getCookies()) {
                cookieRepo.save(CookieEntity.builder()
                        .value(cookie.getValue())
                        .build());
            }
        }

        return AuthResponseDTO.builder()
                .jwt(jwtService.createToken(user))
                .status(200)
                .build();
    }

    public AuthResponseDTO authenticate(AuthRequestDTO authData, HttpServletRequest request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authData.getEmail(),
                        authData.getPassword()
                )
        );

        User user = userRepo.findByEmail(authData.getEmail())
                .orElseThrow();

        if (request != null) {
            for (Cookie cookie : request.getCookies()) {
                cookieRepo.save(CookieEntity.builder()
                        .value(cookie.getValue())
                        .build());
            }
        }

        return AuthResponseDTO.builder()
                .jwt(jwtService.createToken(user))
                .status(200)
                .build();
    }
}





