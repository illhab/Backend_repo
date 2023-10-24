package com.illhab.illhabServer.dto;

import com.illhab.illhabServer.entity.Project;
import lombok.Getter;

public class ProjectDto {

    @Getter
    public static class CreateRequest {

        private Long groupId;
        private String name;
        private Long leader;
    }

    @Getter
    public static class CreateResponse {

        private Long id;
        private String name;
        private Long leader;

        public CreateResponse(Project project) {
            this.id = project.getId();
            this.name = project.getName();
            this.leader = project.getLeader();
        }
    }

}
