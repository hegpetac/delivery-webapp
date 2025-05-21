package com.backend.user.controller;

import com.backend.user.service.AuthService;
import com.backend.userapi.UserApi;
import com.backend.userapi.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@RequiredArgsConstructor
public class UserController implements UserApi {
    private final AuthService authService;

    @CrossOrigin("http://localhost:4200")
    @Override
    public ResponseEntity<AuthResp> login(AuthReq authReq){
        AuthResp authResp;
        try {
           authResp  = authService.login(authReq);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return ResponseEntity.ok(authResp);
    }

    @CrossOrigin("http://localhost:4200")
    @Override
    public ResponseEntity<AuthResp> register(RegisterReq registerReq){
        AuthResp authResp;
        try {
            authResp = authService.register(registerReq);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return ResponseEntity.ok(authResp);
    }
}
