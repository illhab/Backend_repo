package com.illhab.illhabServer.controller;

import com.illhab.illhabServer.dto.ProjectDto;
import com.illhab.illhabServer.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/projects")
    public ResponseEntity<ProjectDto.CreateResponse> createProject(
        @RequestBody ProjectDto.CreateRequest projectDto) {
        return ResponseEntity.ok().body(projectService.create(projectDto));
    }
}
