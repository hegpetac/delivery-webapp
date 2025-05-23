package com.backend.user.service;

import com.backend.jwtutil.JwtUtil;
import com.backend.user.entity.ERole;
import com.backend.user.entity.User;
import com.backend.user.exception.UserException;
import com.backend.user.repository.RoleRepository;
import com.backend.user.repository.UserRepository;
import com.backend.userapi.AuthReq;
import com.backend.userapi.AuthResp;
import com.backend.userapi.RegisterReq;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Import(JwtUtil.class)
public class AuthService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final JwtUtil jwtUtil;

    public AuthResp login(AuthReq authReq) throws UserException {
        try {
            User user = userRepository.findByUsername(authReq.getUsername());

            if (!new BCryptPasswordEncoder().matches(authReq.getPassword(), user.getPassword())) {
                throw new UserException("Helytelen felhasználó név vagy jelszó!");
            }

            String token = jwtUtil.generateToken(user.getUsername(), user.getRole().getName().value());
            return new AuthResp(token);
        } catch (Exception e) {
            throw new UserException("Helytelen felhasználó név vagy jelszó!");
        }
    }

    public AuthResp register(RegisterReq registerReq) throws UserException {
        if(userRepository.findByUsername(registerReq.getUsername()) != null) {
            throw new UserException("Ez a felhasználó név már foglalt!");
        }

        User user = new User();
        user.setUsername(registerReq.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(registerReq.getPassword()));
        user.setRole(roleRepository.findByName(ERole.CUSTOMER));
        userRepository.save(user);
        String token = jwtUtil.generateToken(user.getUsername(), user.getRole().getName().value());
        return new AuthResp(token);
    }
}
