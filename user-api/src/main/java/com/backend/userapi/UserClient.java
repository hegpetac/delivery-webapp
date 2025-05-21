package com.backend.userapi;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user", path = "/api/auth")
public interface UserClient extends UserApi {

    @PostMapping("/login")
    ResponseEntity<AuthResp> login(@RequestBody AuthReq authReq);

    @PostMapping("/register")
    ResponseEntity<AuthResp> register(@RequestBody AuthReq authReq);
}
