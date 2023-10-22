package com.illhab.illhabServer.jpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import com.illhab.illhabServer.entity.Group;
import com.illhab.illhabServer.repository.GroupRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class GroupRepositoryTest {

    @Autowired
    private GroupRepository groupRepository;

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
}
