package com.illhab.illhabServer.service;

import com.illhab.illhabServer.dto.GroupDto;

public interface GroupService {

    GroupDto.CommonResponse create(GroupDto.CommonRequest requests);
}
