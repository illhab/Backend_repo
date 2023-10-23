package com.illhab.illhabServer.jpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import com.illhab.illhabServer.entity.Group;
import com.illhab.illhabServer.entity.Project;
import com.illhab.illhabServer.entity.User;
import com.illhab.illhabServer.entity.UserProject;
import com.illhab.illhabServer.repository.GroupRepository;
import com.illhab.illhabServer.repository.ProjectRepository;
import com.illhab.illhabServer.repository.UserProjectRepository;
import com.illhab.illhabServer.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
public class UserProjectRepositoryTest {

    @Autowired
    private UserProjectRepository userProjectRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private ProjectRepository projectRepository;

    public UserProjectRepositoryTest() {
    }

    @Test
    @Transactional
    @DisplayName("프로젝트로 유저 초대 테스트 케이스")
    public void 프로젝트_초대() {
        //given
        User insertUser = userRepository.save(
            User.builder()
                .email("test@test.com")
                .name("TEST")
                .sns_role("kakao")
                .build());

        Group insertGroup = groupRepository.save(
            Group.builder()
                .name("testGroup")
                .build());

        Project insertProject = projectRepository.save(Project.builder()
            .group(insertGroup)
            .leader(1L)
            .name("testProject")
            .build());

        UserProject insertUserProject = userProjectRepository.save(UserProject.builder()
            .user(insertUser)
            .project(insertProject)
            .build());

        //when
        UserProject saveUserProeject = userProjectRepository.findById(insertUserProject.getId())
            .orElseThrow(() -> new IllegalArgumentException("해당 유저프로젝트가 존재하지 않습니다."));

        //then
        assertThat(saveUserProeject).isEqualTo(insertUserProject);
    }

    @Test
    @Transactional
    @DisplayName("프로젝트로 유저 추방 테스트 케이스")
    public void 프로젝트_추방() {
        //given
        User insertUser = userRepository.save(
            User.builder()
                .email("test@test.com")
                .name("TEST")
                .sns_role("kakao")
                .build());

        Group insertGroup = groupRepository.save(
            Group.builder()
                .name("testGroup")
                .build());

        Project insertProject = projectRepository.save(Project.builder()
            .group(insertGroup)
            .leader(1L)
            .name("testProject")
            .build());

        UserProject insertUserProject = userProjectRepository.save(UserProject.builder()
            .user(insertUser)
            .project(insertProject)
            .build());

        UserProject saveUserProject = userProjectRepository.findById(insertUserProject.getId())
            .orElseThrow(() -> new IllegalArgumentException("해당 유저프로젝트가 존재하지 않습니다."));

        //when
        saveUserProject.ban();

        UserProject bannedUserProject = userProjectRepository.findById(insertUserProject.getId())
            .orElseThrow(() -> new IllegalArgumentException("해당 유저프로젝트가 존재하지 않습니다."));

        //then
        assertThat(bannedUserProject.getIsBanned()).isEqualTo(1);
    }
}
