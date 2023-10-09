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
import lombok.Data;

@Data
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

}
