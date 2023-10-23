package com.illhab.illhabServer.jpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import com.illhab.illhabServer.dto.GroupDto.CommonResponse;
import com.illhab.illhabServer.entity.Group;
import com.illhab.illhabServer.entity.Project;
import com.illhab.illhabServer.entity.User;
import com.illhab.illhabServer.entity.UserProject;
import com.illhab.illhabServer.repository.GroupRepository;
import com.illhab.illhabServer.repository.ProjectRepository;
import com.illhab.illhabServer.repository.UserProjectRepository;
import com.illhab.illhabServer.repository.UserRepository;
import com.illhab.illhabServer.service.GroupService;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class GroupRepositoryTest {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private GroupService groupService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserProjectRepository userProjectRepository;


    @Test
    @Transactional
    @DisplayName("그룹 정상 생성 테스트 케이스")
    void 그룹_생성() {
        //given
        Group insertGroup = Group.builder().leaderId(10L).name("testGroup").build();

        //when
        Group saveGroup = groupRepository.save(insertGroup);

        //then
        Group newGroup = groupRepository.findById(saveGroup.getId())
            .orElseThrow(() -> new IllegalArgumentException("그룹이 존재하지 않습니다."));

        assertThat(newGroup).isEqualTo(saveGroup);
    }

    @Test
    @Transactional
    @DisplayName("유저가 속한 그룹 조회 테스트 케이스")
    void 유저의_그룹_목록() {
        //given
        User insertUser = userRepository.save(
            User.builder()
                .email("test@test.com")
                .name("TEST")
                .sns_role("kakao")
                .build());
        Group insertGroup = Group.builder().leaderId(insertUser.getId()).name("testGroup").build();
        Project insertProject = Project.builder().group(insertGroup).name("testProject").leader(
            insertUser.getId()).build();

        UserProject insertUserProject = UserProject.builder().user(insertUser)
            .project(insertProject).build();

        //when
        User saveUser = userRepository.save(insertUser);
        Group saveGroup = groupRepository.save(insertGroup);
        Project saveProject = projectRepository.save(insertProject);
        UserProject saveUserProject = userProjectRepository.save(insertUserProject);

        //then
        List<CommonResponse> userGroups = groupService.getUserGroups(saveUser.getId());
        assertThat(userGroups).isNotNull();
    }
}
