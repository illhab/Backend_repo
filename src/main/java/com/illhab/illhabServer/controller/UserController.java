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

    @PostMapping("/join")
    public ResponseEntity<UserDto.Response> join(@RequestBody UserDto.Request userDto) {
//        String name = joinRequest.getName();
//        String email = joinRequest.getEmail();
//        String sns_role = joinRequest.getSns_role();
//
//        String result = userService.join(name, email, sns_role);
//        if(result.equalsIgnoreCase("success")){
//            return "success";
//        } else if(result.equalsIgnoreCase("already join"))
//        {
//            return "already join";
//        }else {
//            return "fail";
//        }
        return ResponseEntity.ok().body(userService.join(userDto));

    }
}
