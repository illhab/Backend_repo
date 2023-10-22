package com.illhab.illhabServer.service;

import static com.illhab.illhabServer.entity.ErrorCode.DUPLICATE_RESOURCE;

import com.illhab.illhabServer.dto.ProjectDto;
import com.illhab.illhabServer.dto.UserProjectDto;
import com.illhab.illhabServer.entity.Project;
import com.illhab.illhabServer.entity.User;
import com.illhab.illhabServer.entity.UserProject;
import com.illhab.illhabServer.exception.CustomException;
import com.illhab.illhabServer.repository.ProjectRepository;
import com.illhab.illhabServer.repository.UserProjectRepository;
import com.illhab.illhabServer.repository.UserRepository;
import java.util.Optional;
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
    public UserProjectDto.Response join(Long projectId, Long userId) {
        Project project = projectRepository.findById(projectId)
            .orElseThrow(() -> new IllegalArgumentException("해당 프로젝트가 존재하지 않습니다."));

        User user = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));

        UserProject userProject = UserProject.builder()
            .user(user)
            .project(project)
            .build();

        boolean isExistsUserProject = userProjectRepository.existsByUserIdAndProjectId(user.getId(),
            project.getId());

        if (isExistsUserProject) {
            //Duplicated 커스텀 예외 추가 필요
            throw new CustomException(DUPLICATE_RESOURCE);
        }

        return new UserProjectDto.Response(userProjectRepository.save(userProject));
    }

    @Override
    public UserProjectDto.Response ban(Long projectId, Long userId) {
        Project project = projectRepository.findById(projectId)
            .orElseThrow(() -> new IllegalArgumentException("해당 프로젝트가 존재하지 않습니다."));

        User user = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));

        Optional<UserProject> userProject = Optional.ofNullable(
            userProjectRepository.findByUserIdAndProjectId(
                    user.getId(),
                    project.getId())
                .orElseThrow(() -> new IllegalArgumentException("프로젝트에 존재하지 않는 유저입니다.")));

        UserProject _userProject = userProject.get();
        _userProject.ban();

        return new UserProjectDto.Response(_userProject);
    }
}
