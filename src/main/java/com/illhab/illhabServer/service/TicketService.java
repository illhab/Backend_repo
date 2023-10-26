package com.illhab.illhabServer.service;

import com.illhab.illhabServer.dto.TicketDto;
import com.illhab.illhabServer.dto.TicketDto.CommonResponse;
import com.illhab.illhabServer.dto.TicketDto.UpdateRequest;
import java.util.List;

public interface TicketService {

    TicketDto.CommonResponse create(TicketDto.CommonRequest request);

    List<TicketDto.CommonResponse> getTickets(Long projectId);

    CommonResponse delete(Long ticketId);

    CommonResponse update(Long ticketId, UpdateRequest request);
}
