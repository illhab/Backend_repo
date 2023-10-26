package com.illhab.illhabServer.service;

import com.illhab.illhabServer.dto.UserDto;
import com.illhab.illhabServer.dto.UserDto.*;
import com.illhab.illhabServer.entity.User;
import com.illhab.illhabServer.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public JoinResponse join(UserDto.JoinRequest userDto) {

        //가입 여부 확인
        if (userRepository.existsByEmail(userDto.getEmail())) {
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

    @Override
    public UserResponse getUser(Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다."));
        return new UserResponse(user);
    }

    @Override
    public UpdateResponse update(Long userId, UserDto.UpdateRequest userDto) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다."));

        user.changeName(userDto.getName());

        //이미 존재하는 PK에 대해서 save를 사용하면 update를 진행합니다.
        return new UpdateResponse(userRepository.save(user));

    }

    @Override
    public DeleteResponse delete(Long userId) {

        User user = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다."));

        user.delete();

        return new DeleteResponse(true);
    }
}
