package com.rali.ws.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "users")
@RequiredArgsConstructor
public class UserController {

    @GetMapping(value = "status/check")
    public String status() {
        return "Working...";
    }

    @Secured("ROLE_user")
    @DeleteMapping(path = "{id}")
    public String deleteUser(@PathVariable String id) {
        return "Deleted user with id: " + id;
    }
}
