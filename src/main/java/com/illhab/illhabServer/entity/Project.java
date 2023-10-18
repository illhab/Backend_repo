package com.illhab.illhabServer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tb_project")
@Entity
public class Project extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "project")
    private List<UserProject> userProjects = new ArrayList<>();

    @ManyToOne
    private Group group;

    @OneToMany(mappedBy = "project")
    private List<Ticket> tickets = new ArrayList<>();

    private String name;

    private Long leader;

    @Builder
    public Project(Group group, String name, Long leader) {
        this.group = group;
        this.name = name;
        this.leader = leader;
    }
}
