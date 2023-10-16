package com.illhab.illhabServer.service;

import com.illhab.illhabServer.dto.ProjectDto;
import com.illhab.illhabServer.dto.UserProjectDto;
import com.illhab.illhabServer.entity.Project;
import com.illhab.illhabServer.entity.User;
import com.illhab.illhabServer.entity.UserProject;
import com.illhab.illhabServer.repository.ProjectRepository;
import com.illhab.illhabServer.repository.UserProjectRepository;
import com.illhab.illhabServer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final UserProjectRepository userProjectRepository;
    private final UserRepository userRepository;

    @Override
    public ProjectDto.CreateResponse create(ProjectDto.CreateRequest request) {
        Project project = Project.builder()
            .group(request.getGroup())
            .name(request.getName())
            .leader(request.getLeader())
            .build();

        return new ProjectDto.CreateResponse(projectRepository.save(project));
    }

    @Override
    public UserProjectDto.JoinResponse join(Long projectId, Long userId) {
        Project project = projectRepository.findById(projectId)
            .orElseThrow(() -> new IllegalArgumentException("해당 프로젝트가 존재하지 않습니다."));

        User user = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));

        UserProject userProject = UserProject.builder()
            .user(user)
            .project(project)
            .build();

        return new UserProjectDto.JoinResponse(userProjectRepository.save(userProject));
    }
}
