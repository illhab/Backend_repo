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
    public UserDto.UserResponse getUser(Long userId) {
        //해당 회원 있는지 조회
        if (!userRepository.existsById(userId)) {
            throw new IllegalArgumentException(); //보통 Custom Exception 생성후 처리함
        }

        User user = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다."));
        return new UserDto.UserResponse(user);
    }

    @Override
    public UserDto.UpdateResponse update(Long userId, UserDto.UpdateRequest userDto) {
        //해당 회원 있는지 조회
        if (!userRepository.existsById(userId)) {
            throw new IllegalArgumentException(); //보통 Custom Exception 생성후 처리함
        }

        User user = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다."));

        user.changeName(userDto.getName());

        //이미 존재하는 PK에 대해서 save를 사용하면 update를 진행합니다.
        return new UserDto.UpdateResponse(userRepository.save(user));

    }

    @Override
    public UserDto.DeleteResponse delete(Long userId) {
        //해당 회원 있는지 조회
        if (!userRepository.existsById(userId)) {
            //없다면 false반환
            return new UserDto.DeleteResponse(userRepository.existsById(userId));
        }
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다."));

        user.delete();

        return new UserDto.DeleteResponse(true);
    }
}
