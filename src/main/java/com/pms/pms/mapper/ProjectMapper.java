package com.pms.pms.mapper;

import com.pms.pms.Dto.ProjectDto;
import com.pms.pms.Entity.Project;
import com.pms.pms.Entity.Staff;
import lombok.Builder;

@Builder
public class ProjectMapper {

    public static ProjectDto mapToProjectDto(Project project){
        return ProjectDto.builder()
                .id(project.getId())
                .project_title(project.getProject_title())
                .description(project.getDescription())
                .staff(project.getStaff())
                .comments(project.getComments())
                .build();
    }

    public static Project mapToProject(ProjectDto projectDto){

        return Project.builder()
                .id(projectDto.getId())
                .project_title(projectDto.getProject_title())
                .description(projectDto.getDescription())
                .comments(projectDto.getComments())
                .build();
    }
}
