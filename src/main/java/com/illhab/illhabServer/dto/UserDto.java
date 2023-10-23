package com.illhab.illhabServer.dto;

import com.illhab.illhabServer.entity.SNS_ROLE;
import com.illhab.illhabServer.entity.User;
import java.util.List;
import lombok.Getter;

public class UserDto {

    @Getter
    public static class JoinRequest {

        private String name;
        private String email;
        private SNS_ROLE sns_role;
    }

    @Getter
    public static class JoinResponse {

        private String name;
        private String email;
        private SNS_ROLE sns_role;

        /* Entity -> DTO Response */
        public JoinResponse(User user) {
            this.name = user.getName();
            this.email = user.getEmail();
            this.sns_role = user.getSns_role();
        }
    }

    @Getter
    public static class ListResponse {

        private List<User> users;

        public ListResponse(List<User> users) {
            this.users = users;
        }

    }

    @Getter
    public static class UserResponse {

        private User user;

        public UserResponse(User user) {
            this.user = user;
        }
    }

    @Getter
    public static class UpdateRequest {

        private String name;
    }

    @Getter
    public static class UpdateResponse {

        private String name;
        private String email;

        public UpdateResponse(User user) {
            this.name = user.getName();
            this.email = user.getEmail();
        }
    }

    @Getter
    public static class DeleteResponse {

        private Boolean result;

        public DeleteResponse(boolean result) {
            this.result = result;
        }
    }

}
