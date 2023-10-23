package com.illhab.illhabServer.service;

import com.illhab.illhabServer.dto.ProjectDto;
import com.illhab.illhabServer.dto.UserProjectDto;

public interface ProjectService {

    ProjectDto.CreateResponse create(ProjectDto.CreateRequest request);

    UserProjectDto.Response join(Long projectId, Long userId);

    UserProjectDto.Response ban(Long projectId, Long userId);
}
