package com.illhab.illhabServer.controller;

import com.illhab.illhabServer.dto.UserDto;
import com.illhab.illhabServer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/users")
    public ResponseEntity<UserDto.ListResponse> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserDto.UserResponse> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok().body(userService.getUser(userId));
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<UserDto.UpdateResponse> update(@PathVariable Long userId,
        @RequestBody UserDto.UpdateRequest userDto) {
        return ResponseEntity.ok().body(userService.update(userId, userDto));
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<UserDto.DeleteResponse> delete(@PathVariable Long userId) {
        return ResponseEntity.ok().body(userService.delete(userId));
    }

}
