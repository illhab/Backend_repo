package com.illhab.illhabServer.service;

import com.illhab.illhabServer.dto.ProjectDto;
import com.illhab.illhabServer.dto.ProjectDto.CreateResponse;
import com.illhab.illhabServer.entity.Project;
import com.illhab.illhabServer.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public ProjectDto.CreateResponse create(ProjectDto.CreateRequest request) {
        Project project = Project.builder()
            .group(request.getGroup())
            .name(request.getName())
            .leader(request.getLeader())
            .build();

        return new CreateResponse(projectRepository.save(project));
    }
}
