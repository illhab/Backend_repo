package com.illhab.illhabServer.controller.dto;

import com.illhab.illhabServer.entity.SNS_ROLE;
import lombok.Data;

@Data
public class JoinRequest {
    private String name;
    private String email;
    private String sns_role;
}
