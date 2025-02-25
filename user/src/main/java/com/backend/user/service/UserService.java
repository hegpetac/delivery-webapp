package com.backend.user.service;

import com.backend.user.entity.Role;
import com.backend.user.entity.User;
import com.backend.user.exception.UserException;
import com.backend.user.mapper.UserMapper;
import com.backend.user.repository.RoleRepository;
import com.backend.user.repository.UserRepository;
import com.backend.userapi.model.LoginReq;
import com.backend.userapi.model.LoginResp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class UserService {
    @Value("${deliveryWebapp.jwtSecret}")
    private String secret;

    @Value("${deliveryWebapp.jwtExpirationMs}")
    private String expirationTime;

    private Key key;

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;

    public LoginResp login(LoginReq loginReq) throws UserException {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginReq.getUsername(), loginReq.getPassword()));
        } catch (AuthenticationException e) {
            throw new UserException(e.getMessage());
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return generateLoginResp(userRepository.findByUsername(userDetails.getUsername()));
    }

    private LoginResp generateLoginResp(User user) throws UserException {
        com.backend.userapi.model.User userModel = userMapper.mapUserToModel(user);
        Role role = user.getRole();
        try {
            LoginResp resp = new LoginResp();
            resp.setUser(userModel);
            resp.setRole(userMapper.mapRoleToModel(role));
            resp.setJwt(generateJwtToken(userModel, role));
            return resp;
        } catch (Exception e) {
            throw new UserException(e.getMessage());
        }
    }

    private String generateJwtToken(com.backend.userapi.model.User user, Role role) throws JsonProcessingException {
        Long expirationTimeLong = Long.parseLong(expirationTime);
        final Date creationDate = new Date();
        final Date expirationDate = new Date(creationDate.getTime() + expirationTimeLong * 1000);
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role.getName().name());
        ObjectMapper objectMapper = new ObjectMapper();
        String userJSON = objectMapper.writeValueAsString(user);
        return "";
    }
}
