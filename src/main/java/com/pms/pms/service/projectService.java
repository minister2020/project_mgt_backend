package com.pms.pms.service;

import com.pms.pms.Entity.Project;


import java.util.List;
import java.util.Optional;

public interface projectService {
    Project uploadProject(Project project);
    List<Project> viewAllProject();
    Optional<Project> viewProjectById(Long id);

    Project updateProject(Project project, Long id);

    void deleteProject(Long id);

}
