package com.illhab.illhabServer.dto;

import com.illhab.illhabServer.entity.SNS_ROLE;
import com.illhab.illhabServer.entity.User;
import lombok.Getter;

public class UserDto {

    @Getter
    public static class Request {

        private String name;
        private String email;
        private String sns_role;
    }

    @Getter
    public static class Response {

        private String name;
        private String email;
        private SNS_ROLE sns_role;

        /* Entity -> DTO Response */
        public Response(User user) {
            this.name = user.getName();
            this.email = user.getEmail();
            this.sns_role = user.getSns_role();
        }
    }
}
