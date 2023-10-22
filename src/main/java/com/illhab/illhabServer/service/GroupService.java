package com.illhab.illhabServer.service;

import com.illhab.illhabServer.dto.GroupDto;
import java.util.List;

public interface GroupService {

    GroupDto.CommonResponse create(GroupDto.CommonRequest requests);

    List<GroupDto.CommonResponse> getUserGroups(Long userId);

}
