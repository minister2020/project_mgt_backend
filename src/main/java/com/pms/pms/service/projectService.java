package com.pms.pms.service;

import com.pms.pms.Dto.APIResponse;
import com.pms.pms.Dto.ProjectDto;
import com.pms.pms.Entity.Project;


import java.util.List;
import java.util.Optional;

public interface projectService {
    APIResponse<?> uploadProject(ProjectDto projectDto);
    List<Project> viewAllProject();
    Optional<Project> viewProjectByUser(Long userId);

    Project updateProject(Project project, Long id);

    void deleteProject(Long id);

}
