package com.illhab.illhabServer.controller;

import com.illhab.illhabServer.dto.UserDto;
import com.illhab.illhabServer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserDto.JoinResponse> join(@RequestBody UserDto.JoinRequest userDto) {
        return ResponseEntity.ok().body(userService.join(userDto));

    }
}
