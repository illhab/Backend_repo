package com.illhab.illhabServer.controller;

import com.illhab.illhabServer.dto.UserDto;
import com.illhab.illhabServer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserDto.JoinResponse> join(@RequestBody UserDto.JoinRequest userDto) {
        return ResponseEntity.ok().body(userService.join(userDto));
    }

    @GetMapping("/users")
    public ResponseEntity<UserDto.ListResponse> users() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/users/{email}")
    public ResponseEntity<UserDto.UserResponse> users(@PathVariable String email) {
        return ResponseEntity.ok().body(userService.getUser(email));
    }

    @PutMapping("/users/{email}")
    public ResponseEntity<UserDto.UpdateResponse> update(@PathVariable String email, @RequestBody UserDto.UpdateRequest userDto){
        return ResponseEntity.ok().body(userService.update(email, userDto));
    }

    @DeleteMapping("/users/{email}")
    public ResponseEntity<UserDto.DeleteResponse> delete(@PathVariable String email){
        return ResponseEntity.ok().body(userService.delete(email));
    }

}
