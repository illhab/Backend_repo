package com.illhab.illhabServer.entity;

import com.illhab.illhabServer.dto.TicketDto.UpdateRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_ticket")
@Entity
public class Ticket extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Project project;

    private String title;
    private String content;
    private Long author_userId;
    private Long reporter_userId;
    private TICKET_STATUS status;
    @Column(columnDefinition = "integer default 0")
    private int isDeleted;

    @Builder
    public Ticket(Long id, Project project, String title, String content, Long author_userId,
        Long reporter_userId,
        TICKET_STATUS status) {
        this.id = id;
        this.project = project;
        this.title = title;
        this.content = content;
        this.author_userId = author_userId;
        this.reporter_userId = reporter_userId;
        this.status = status;
    }

    public void delete() {
        this.isDeleted = 1;
    }

    public void update(UpdateRequest request) {
        this.title = request.getTitle();
        this.content = request.getContent();
        this.author_userId = request.getAuthor_userId();
        this.reporter_userId = request.getReporter_userId();
        this.status = request.getStatus();
    }
}
