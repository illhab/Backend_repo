package com.illhab.illhabServer.jpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.illhab.illhabServer.entity.SNS_ROLE;
import com.illhab.illhabServer.entity.User;
import com.illhab.illhabServer.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    @DisplayName("정상 유저 회원가입 및 조회 테스트 케이스")
    public void 유저_생성() {
        //given
        User insertUser = userRepository.save(
            User.builder()
                .email("test@test.com")
                .name("TEST")
                .sns_role("kakao")
                .build());

        //when
        User saveUser = userRepository.findById(insertUser.getId())
            .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));

        //then
        assertThat(insertUser).isEqualTo(saveUser);
    }

    @Test
    @Transactional
    @DisplayName("정상 유저 회원가입 회원 삭제 테스트")
    public void 유저_삭제() {
        //given
        User insertUser = userRepository.save(
            User.builder()
                .email("test@test.com")
                .name("TEST")
                .sns_role("kakao")
                .build());

        //when
        userRepository.deleteById(insertUser.getId());

        //then (예외가 발생해야 성공)
        assertThrows(IllegalArgumentException.class, () -> {
            userRepository.findById(insertUser.getId())
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));
        });
    }

    @Test
    @Transactional
    @DisplayName("유저 조회 성공")
    public void 유저_조회_성공() {
        //given
        User insertUser = userRepository.save(
                User.builder()
                        .email("test@test.com")
                        .name("TEST")
                        .sns_role("kakao")
                        .build());

        //when
        User selectUser = userRepository.findByEmail("test@test.com");

        //then
        assertThat(selectUser).isNotNull();

    }

    @Test
    @Transactional
    @DisplayName("유저 조회 실패")
    public void 유저_조회_실패() {
        //given
        User insertUser = userRepository.save(
                User.builder()
                        .email("test@test.com")
                        .name("TEST")
                        .sns_role("kakao")
                        .build());

        //when
        User selectUser = userRepository.findByEmail("test111@test.com");

        //then
        assertThat(selectUser).isNotNull();

    }

}
