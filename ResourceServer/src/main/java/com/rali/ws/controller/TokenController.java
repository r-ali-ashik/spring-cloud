package com.rali.ws.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "token")
@RequiredArgsConstructor
public class TokenController {

    @GetMapping
    public ResponseEntity<Jwt> getToken(@AuthenticationPrincipal Jwt jwt) {
        return ResponseEntity.ok(jwt);
    }
}
