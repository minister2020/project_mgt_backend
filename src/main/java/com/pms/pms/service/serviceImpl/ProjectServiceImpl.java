package com.pms.pms.service.serviceImpl;

import com.pms.pms.Entity.Comment;
import com.pms.pms.Entity.Project;

import com.pms.pms.Exception.ResourceNotFoundException;
import com.pms.pms.Repository.ProjectRepository;
import com.pms.pms.service.projectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProjectServiceImpl implements projectService {
//    @Embedded
//    @Autowired

  private  final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project uploadProject(Project project) {
        Project project1 = new Project();
        project1.setId(project.getId());
        project1.setProject_title(project.getProject_title());
        project1.setDescription(project.getDescription());
        return projectRepository.save(project);

    }

    @Override
    public List<Project> viewAllProject() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> viewProjectById(Long id) {
        Optional<Project> project = Optional.ofNullable(projectRepository.findProjectById(id).get());
        if (project.isPresent()) {
            return Optional.of(project.get());
        } else {
            throw new ResourceNotFoundException("Project", "id", id);
        }
    }

    @Override
    public Project updateProject(Project project, Long id) {
        Project existingProject  = projectRepository.findProjectById(id).get();
        existingProject.setProject_title(project.getProject_title());
        existingProject.setDescription(project.getDescription());
        return projectRepository.save(project);

    }

    @Override
    public void deleteProject(Long id) {
     projectRepository.deleteById(id);
    }
}
