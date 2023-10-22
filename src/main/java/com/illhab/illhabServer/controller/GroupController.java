package com.illhab.illhabServer.controller;

import com.illhab.illhabServer.dto.GroupDto;
import com.illhab.illhabServer.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GroupController {

    private final GroupService groupService;

    @PostMapping("/group")
    public ResponseEntity<GroupDto.CommonResponse> create(
        @RequestBody GroupDto.CommonRequest request) {
        return ResponseEntity.ok().body(groupService.create(request));
    }

}
