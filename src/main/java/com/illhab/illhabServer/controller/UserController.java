package com.illhab.illhabServer.controller;

import com.illhab.illhabServer.controller.dto.JoinRequest;
import com.illhab.illhabServer.entity.SNS_ROLE;
import com.illhab.illhabServer.entity.User;
import com.illhab.illhabServer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private  final UserService userService;

    @PostMapping("/join")
    public String join(@RequestBody JoinRequest joinRequest){
        String name = joinRequest.getName();
        String email = joinRequest.getEmail();
        String sns_role = joinRequest.getSns_role();

        String result = userService.join(name, email, sns_role);
        if(result.equalsIgnoreCase("success")){
            return "success";
        } else if(result.equalsIgnoreCase("already join"))
        {
            return "already join";
        }else {
            return "fail";
        }
    }
}
