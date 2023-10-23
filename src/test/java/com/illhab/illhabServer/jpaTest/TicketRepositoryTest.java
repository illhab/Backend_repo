package com.illhab.illhabServer.jpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import com.illhab.illhabServer.entity.Group;
import com.illhab.illhabServer.entity.Project;
import com.illhab.illhabServer.entity.TICKET_STATUS;
import com.illhab.illhabServer.entity.Ticket;
import com.illhab.illhabServer.repository.GroupRepository;
import com.illhab.illhabServer.repository.ProjectRepository;
import com.illhab.illhabServer.repository.TicketRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class TicketRepositoryTest {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Test
    @Transactional
    @DisplayName("티켓 생성, 삭제, 업데이트 테스트 케이스")
    void 티켓_생성() {
        //given
        Group insertGroup = Group.builder().leaderId(2L).name("testGroup").build();

        Project insertProject = Project.builder().group(insertGroup).name("testProject").leader(
            2L).build();

        Ticket insertTicket = Ticket.builder()
            .title("testTitle")
            .content("testContent")
            .project(insertProject)
            .author_userId(1L)
            .reporter_userId(1L)
            .status(TICKET_STATUS.TODO)
            .build();

        //when
        groupRepository.save(insertGroup);
        projectRepository.save(insertProject);
        ticketRepository.save(insertTicket);

        //then
        Ticket saveTicket = ticketRepository.findById(insertTicket.getId())
            .orElseThrow(() -> new IllegalArgumentException("티켓이 존재하지 않습니다."));

        assertThat(saveTicket).isEqualTo(insertTicket);
    }

}
