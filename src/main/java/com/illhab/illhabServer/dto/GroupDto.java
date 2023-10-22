package com.illhab.illhabServer.dto;

import com.illhab.illhabServer.entity.Group;
import com.illhab.illhabServer.entity.Project;
import java.util.List;
import lombok.Getter;

public class GroupDto {

    @Getter
    public static class CommonRequest {

        private Long leaderId;
        private String name;
    }

    @Getter
    public static class CommonResponse {

        private Long id;
        private List<Project> projects;
        private final String name;

        public CommonResponse(Group group) {
            this.id = group.getId();
            this.name = group.getName();
            this.projects = group.getProjects();
        }

    }
}
