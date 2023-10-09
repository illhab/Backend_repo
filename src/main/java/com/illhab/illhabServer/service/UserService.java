package com.illhab.illhabServer.service;

import com.illhab.illhabServer.entity.SNS_ROLE;

public interface UserService {
    String join(String name, String email, String sns_role);
}
