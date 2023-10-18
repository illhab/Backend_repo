package com.illhab.illhabServer.dto;

import com.illhab.illhabServer.entity.UserProject;
import lombok.Getter;

public class UserProjectDto {

    @Getter
    public static class JoinResponse {

        Long projectId;
        Long userId;

        public JoinResponse(UserProject userProject) {
            this.projectId = userProject.getProject().getId();
            this.userId = userProject.getUser().getId();
        }
    }

}
