package com.illhab.illhabServer.service;

import com.illhab.illhabServer.dto.ProjectDto;
import com.illhab.illhabServer.dto.UserProjectDto.JoinResponse;

public interface ProjectService {

    ProjectDto.CreateResponse create(ProjectDto.CreateRequest request);

    JoinResponse join(Long projectId, Long userId);
}
