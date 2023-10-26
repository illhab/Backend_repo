package com.illhab.illhabServer.controller;

import com.illhab.illhabServer.dto.TicketDto;
import com.illhab.illhabServer.service.TicketService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class TicketController {

    private final TicketService ticketService;

    @GetMapping("/tickets/{projectId}")
    public ResponseEntity<List<TicketDto.CommonResponse>> getTickets(@PathVariable Long projectId) {
        return ResponseEntity.ok().body(ticketService.getTickets(projectId));
    }

    @PostMapping("/tickets")
    public ResponseEntity<TicketDto.CommonResponse> createTicket(
        @RequestBody TicketDto.CommonRequest request) {
        return ResponseEntity.ok().body(ticketService.create(request));
    }

    @DeleteMapping("/tickets/{ticketId}")
    public ResponseEntity<TicketDto.CommonResponse> deleteTicket(@PathVariable Long ticketId) {
        return ResponseEntity.ok().body(ticketService.delete(ticketId));
    }

    @PutMapping("/tickets/{ticketId}")
    public ResponseEntity<TicketDto.CommonResponse> updateTicket(
        @RequestBody TicketDto.UpdateRequest request) {
        return ResponseEntity.ok().body(ticketService.update(request));
    }
}
