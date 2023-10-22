package com.illhab.illhabServer.service;

import com.illhab.illhabServer.dto.GroupDto.CommonRequest;
import com.illhab.illhabServer.dto.GroupDto.CommonResponse;
import com.illhab.illhabServer.entity.Group;
import com.illhab.illhabServer.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    @Override
    public CommonResponse create(CommonRequest requests) {
        Group group = Group.builder().leaderId(requests.getLeaderId()).name(requests.getName())
            .build();
        return new CommonResponse(groupRepository.save(group));
    }
}
