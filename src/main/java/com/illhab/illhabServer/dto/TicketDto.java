package com.illhab.illhabServer.dto;

import com.illhab.illhabServer.entity.TICKET_STATUS;
import com.illhab.illhabServer.entity.Ticket;
import lombok.Getter;

public class TicketDto {

    @Getter
    public static class CommonRequest {

        private Long projectId;
        private String title;
        private String content;
        private Long author_userId;
        private Long reporter_userId;
        private TICKET_STATUS status;

    }

    @Getter
    public static class UpdateRequest {

        private Long ticketId;
        private String title;
        private String content;
        private Long author_userId;
        private Long reporter_userId;
        private TICKET_STATUS status;
    }

    @Getter
    public static class CommonResponse {

        private Long ticketId;
        private String title;
        private String content;
        private Long author_userId;
        private Long reporter_userId;
        private TICKET_STATUS status;

        public CommonResponse(Ticket ticket) {
            this.ticketId = ticket.getId();
            this.content = ticket.getContent();
            this.title = ticket.getTitle();
            this.author_userId = ticket.getAuthor_userId();
            this.reporter_userId = ticket.getReporter_userId();
            this.status = ticket.getStatus();

        }
    }
}
