package com.illhab.illhabServer.service;

import com.illhab.illhabServer.dto.TicketDto.CommonRequest;
import com.illhab.illhabServer.dto.TicketDto.CommonResponse;
import com.illhab.illhabServer.dto.TicketDto.UpdateRequest;
import com.illhab.illhabServer.entity.Project;
import com.illhab.illhabServer.entity.Ticket;
import com.illhab.illhabServer.repository.ProjectRepository;
import com.illhab.illhabServer.repository.TicketRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final ProjectRepository projectRepository;

    @Override
    public CommonResponse create(CommonRequest request) {
        Project project = projectRepository.findById(request.getProjectId())
            .orElseThrow(() -> new IllegalArgumentException("프로젝트를 찾을 수 없습니다."));

        Ticket ticket = Ticket.builder().project(project)
            .title(request.getTitle())
            .content(request.getContent())
            .author_userId(request.getAuthor_userId())
            .reporter_userId(request.getReporter_userId())
            .status(request.getStatus())
            .build();

        return new CommonResponse(ticketRepository.save(ticket));
    }

    @Override
    public List<CommonResponse> getTickets(Long projectId) {
        List<Ticket> tickets = ticketRepository.findByProjectId(projectId);

        return tickets.stream().map(CommonResponse::new)
            .toList();
    }

    @Override
    public CommonResponse delete(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
            .orElseThrow(() -> new IllegalArgumentException("티켓이 존재하지 않습니다."));
        ticket.delete();
        return new CommonResponse(ticket);
    }

    @Override
    public CommonResponse update(UpdateRequest request) {
        Ticket ticket = ticketRepository.findById(request.getTicketId())
            .orElseThrow(() -> new IllegalArgumentException("티켓이 존재하지 않습니다."));

        ticket.update(request);

        return new CommonResponse(ticket);
    }
}
