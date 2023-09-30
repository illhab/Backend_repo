package com.illhab.illhabServer.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "sample")
@Entity
@NoArgsConstructor
public class Sample {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SAMPLE_ID")
    private Long id;
}