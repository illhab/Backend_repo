package com.illhab.illhabServer.service;

import com.illhab.illhabServer.entity.SNS_ROLE;
import com.illhab.illhabServer.entity.User;
import com.illhab.illhabServer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private  final UserRepository userRepository;
    @Override
    public String join(String name, String email, String sns_role){

        //가입 여부 확인
        User checkUser = userRepository.findByEmail(email);
        if(checkUser != null)
            return "already join";

        //새로 가입
        User newUser = User.builder()
                .name(name)
                .email(email)
                .sns_role(sns_role)
                .build();
        userRepository.save(newUser);
        return "success";
    }


}
