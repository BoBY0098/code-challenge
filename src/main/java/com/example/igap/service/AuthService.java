package com.example.igap.service;

import com.example.igap.exception.ServiceException;
import com.example.igap.model.dto.UserDtoIn;
import com.example.igap.model.dto.auth.AuthenticationReq;
import com.example.igap.model.dto.auth.AuthenticationRes;
import com.example.igap.model.entity.UserEntity;
import com.example.igap.model.Role;
import com.example.igap.dao.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationRes singUp(UserDtoIn userDtoIn) {
        var user = UserEntity.builder()
                .username(userDtoIn.getUsername())
                .password(passwordEncoder.encode(userDtoIn.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationRes.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationRes singIn(AuthenticationReq authenticationReq) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationReq.getUsername(),
                            authenticationReq.getPassword()
                    )
            );
        } catch (Exception e) {
            throw new ServiceException("Username or password is incorrect");
        }
        var user = userRepository.findByUsername(authenticationReq.getUsername())
                .orElseThrow(()-> new ServiceException("User Not Found"));
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationRes.builder()
                .token(jwtToken)
                .build();
    }
}
