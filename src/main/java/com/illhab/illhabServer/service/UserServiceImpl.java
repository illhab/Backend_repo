package com.illhab.illhabServer.service;

import com.illhab.illhabServer.dto.UserDto;
import com.illhab.illhabServer.dto.UserDto.JoinResponse;
import com.illhab.illhabServer.dto.UserDto.ListResponse;
import com.illhab.illhabServer.entity.User;
import com.illhab.illhabServer.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto.JoinResponse join(UserDto.JoinRequest userDto) {

        //가입 여부 확인
        if (!userRepository.existsByEmail(userDto.getEmail())) {
            throw new IllegalArgumentException(); //보통 Custom Exception 생성후 처리함
        }

        //새로 가입
        User newUser = User.builder()
            .name(userDto.getName())
            .email(userDto.getEmail())
            .sns_role(userDto.getSns_role())
            .build();

        return new JoinResponse(userRepository.save(newUser));
    }

    @Override
    public ListResponse getUsers() {
        List<User> users = userRepository.findAll();
        return new ListResponse(users);
    }

}
