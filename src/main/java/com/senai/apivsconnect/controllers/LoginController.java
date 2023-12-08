package com.senai.apivsconnect.controllers;

import com.senai.apivsconnect.dtos.LoginDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class LoginController {

    private AuthenticationManager authenticationManager;
    @PostMapping("/login")
    public ResponseEntity<Object> login(@ResponseBody @Valid LoginDto dadosLogin){
        var userNamePassword = new UsernamePasswordAuthenticationToken(dadosLogin.email(), dadosLogin.senha());

        var auth = authenticationManager.authenticate(userNamePassword);
        return ResponseEntity.status(HttpStatus.OK).body("logado");

    }
}
 