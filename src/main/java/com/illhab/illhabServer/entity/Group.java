package com.illhab.illhabServer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "tb_group")
@Entity
public class Group extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private List<Project> projects = new ArrayList<>();

    private String name;

    private Long leaderId;

    @Builder
    public Group(Long leaderId, String name) {
        this.leaderId = leaderId;
        this.name = name;
    }
}
