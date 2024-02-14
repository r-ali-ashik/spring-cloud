package com.rali.ws.controller;

import com.rali.ws.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "users")
@RequiredArgsConstructor
public class UserController {


    private final Environment environment;

    @GetMapping(value = "status/check")
    public String status() {
        return "Working on port: " + environment.getProperty("local.server.port");
    }

//    @Secured("ROLE_user")
    @PreAuthorize("#id==#jwt.subject")
    @DeleteMapping(path = "{id}")
    public String deleteUser(@AuthenticationPrincipal Jwt jwt,
                             @PathVariable String id) {
        return "Deleted user with id: " + id;
    }

    @GetMapping(path = "{id}")
    @PostAuthorize("returnObject.userId == #id")
    public UserDto getUser(@AuthenticationPrincipal Jwt jwt, @PathVariable String id) {

        return UserDto.builder()
                .userId(jwt.getSubject())
                .build();
    }
}
