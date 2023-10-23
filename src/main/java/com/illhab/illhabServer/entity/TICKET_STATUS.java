package com.illhab.illhabServer.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TICKET_STATUS {
    TODO,
    IN_PROGRESS,
    COMPLETE;

    @JsonCreator
    public static TICKET_STATUS from(String status) {
        return TICKET_STATUS.valueOf(status.toUpperCase());
    }
}
