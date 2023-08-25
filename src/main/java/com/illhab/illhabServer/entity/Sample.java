package com.illhab.illhabServer.entity;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Sample {

    private String sample_String;
    private Integer sample_Integer;
    private Double sample_Double;
    private Timestamp sample_Timestamp;

}
