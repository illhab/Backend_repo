package com.illhab.illhabServer.service;

import com.illhab.illhabServer.dto.ProjectDto;

public interface ProjectService {

    ProjectDto.CreateResponse create(ProjectDto.CreateRequest request);

}
