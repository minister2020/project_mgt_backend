package com.pms.pms.service.serviceImpl;

import com.pms.pms.Dto.APIResponse;
import com.pms.pms.Dto.ProjectDto;
import com.pms.pms.Entity.Comment;
import com.pms.pms.Entity.Project;

import com.pms.pms.Entity.User;
import com.pms.pms.Exception.ResourceNotFoundException;
import com.pms.pms.Repository.ProjectRepository;
import com.pms.pms.Repository.UserRepository;
import com.pms.pms.service.projectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements projectService {
//    @Embedded
//    @Autowired

    private  final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    public APIResponse<?> uploadProject(ProjectDto projectDto) {
        APIResponse<Project> response = new APIResponse<>();
        User user = userRepository.findById(projectDto.getUserId()).get();
        if (user.getRole().toString().equalsIgnoreCase("INTERN")){
            Project project = new Project();
            project.setId(projectDto.getId());
            project.setProject_title(projectDto.getProject_title());
            project.setDescription(projectDto.getDescription());
            project.setUser(user);
            response.setResponse(project);
            response.setStatus("OK");
            projectRepository.save(project);
            return response;
        }else{
            response.setError("Sorry, you are not eligible to add project");
            response.setStatus("BAD REQUEST");
            return response;
        }

    }

    @Override
    public List<Project> viewAllProject() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> viewProjectByUser(Long id) {
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
