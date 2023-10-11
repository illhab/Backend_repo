package com.illhab.illhabServer.service;

import com.illhab.illhabServer.dto.UserDto;

public interface UserService {
    
    UserDto.Response join(UserDto.Request userDto);
}
