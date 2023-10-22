package com.illhab.illhabServer.service;

import com.illhab.illhabServer.dto.GroupDto;
import com.illhab.illhabServer.dto.GroupDto.CommonRequest;
import com.illhab.illhabServer.dto.GroupDto.CommonResponse;
import com.illhab.illhabServer.entity.Group;
import com.illhab.illhabServer.entity.UserProject;
import com.illhab.illhabServer.repository.GroupRepository;
import com.illhab.illhabServer.repository.UserProjectRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GroupServiceImpl implements GroupService {

    private final UserProjectRepository userProjectRepository;
    private final GroupRepository groupRepository;

    @Override
    public CommonResponse create(CommonRequest requests) {
        Group group = Group.builder().leaderId(requests.getLeaderId()).name(requests.getName())
            .build();
        return new CommonResponse(groupRepository.save(group));
    }

    @Override
    public List<GroupDto.CommonResponse> getUserGroups(Long userId) {
        Optional<List<UserProject>> project = userProjectRepository.findByUserId(userId);
        List<UserProject> userProjects = project.orElseThrow(
            () -> new IllegalArgumentException("잘못된 요청입니다."));

        return userProjects.stream()
            .map(userProject -> new CommonResponse(userProject.getProject().getGroup()))
            .toList();
    }
}
