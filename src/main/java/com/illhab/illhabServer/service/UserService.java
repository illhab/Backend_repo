package com.illhab.illhabServer.service;

import com.illhab.illhabServer.dto.UserDto;

public interface UserService {

    UserDto.JoinResponse join(UserDto.JoinRequest userDto);

    UserDto.ListResponse getUsers();
}
