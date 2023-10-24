package com.illhab.illhabServer.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum SNS_ROLE {
    NONE,
    GOOGLE,
    KAKAO,
    GITHUB;

    @JsonCreator
    public static SNS_ROLE from(String status) {
        return SNS_ROLE.valueOf(status.toUpperCase());
    }
}
