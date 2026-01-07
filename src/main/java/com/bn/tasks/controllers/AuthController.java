package com.bn.tasks.controllers;

import com.bn.tasks.Services.AuthService;
import com.bn.tasks.dto.AuthenticationResponse;
import com.bn.tasks.dto.UserLoginDto;
import com.bn.tasks.dto.UserRegisterDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse>  login(@RequestBody @Valid UserLoginDto userLoginDto) {
        return ResponseEntity.status(HttpStatus.OK).body(this.authService.login(userLoginDto));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody @Valid UserRegisterDto userRegisterDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.authService.register(userRegisterDto));
    }

}
