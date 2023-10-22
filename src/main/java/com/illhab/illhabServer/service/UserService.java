package com.illhab.illhabServer.service;

import com.illhab.illhabServer.dto.UserDto;

public interface UserService {

    UserDto.JoinResponse join(UserDto.JoinRequest userDto);

    UserDto.ListResponse getUsers();
    UserDto.UserResponse getUser(String email);
    UserDto.UpdateResponse update(String email, UserDto.UpdateRequest userDto);
    UserDto.DeleteResponse delete(String email);

}
