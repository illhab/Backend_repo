package com.illhab.illhabServer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(name = "tb_user_project")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class UserProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(columnDefinition = "integer default 0")
    private Integer isBanned;


    @Builder
    public UserProject(User user, Project project) {
        this.user = user;
        this.project = project;
    }

    public void ban() {
        this.isBanned = 1;
    }
}
