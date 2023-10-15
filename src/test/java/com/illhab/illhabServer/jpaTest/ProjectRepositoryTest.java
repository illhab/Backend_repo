package com.illhab.illhabServer.jpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import com.illhab.illhabServer.entity.Group;
import com.illhab.illhabServer.entity.Project;
import com.illhab.illhabServer.repository.GroupRepository;
import com.illhab.illhabServer.repository.ProjectRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class ProjectRepositoryTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Test
    @Transactional
    @DisplayName("프로젝트 생성 및 정상 조회 테스트 케이스")
    public void 프로젝트_생성() {
        //given
        Group insertGroup = groupRepository.save(
            Group.builder()
                .name("testGroup")
                .build());

        Project insertProject = Project.builder()
            .group(insertGroup)
            .leader(1L)
            .name("testProject")
            .build();

        projectRepository.save(insertProject);

        //when
        Group saveGroup = groupRepository.findById(insertGroup.getId())
            .orElseThrow(() -> new IllegalArgumentException("해당 그룹이 존재하지 않습니다."));

        Project saveProject = projectRepository.findById(insertProject.getId())
            .orElseThrow(() -> new IllegalArgumentException("해당 프로젝트가 존재하지 않습니다."));

        //then
        assertThat(insertGroup).isEqualTo(saveGroup);
        assertThat(insertProject).isEqualTo(saveProject);
    }
}
