package com.pms.pms.Controller;

import com.pms.pms.Dto.APIResponse;
import com.pms.pms.Dto.ProjectDto;
import com.pms.pms.Entity.Comment;
import com.pms.pms.Entity.Project;
import com.pms.pms.service.CommentService;
import com.pms.pms.service.projectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")

public class ProjectController {

    @Autowired
    projectService projectService;
    @PostMapping("/uploadProject")
   // @PreAuthorize("hasRole('ADMIN')")
    @ResponseBody

    //build add project api
    public ResponseEntity<APIResponse<?>> uploadProject(@RequestBody ProjectDto projectDto){
        APIResponse<?> newProject = projectService.uploadProject(projectDto);
        return new ResponseEntity<>(newProject, HttpStatus.OK);

    }



    //build view all project api

    @GetMapping("/project")
    @ResponseBody
    public List<Project> viewAllProject(){
        return projectService.viewAllProject();
    }


    //build get all comment by id
    @GetMapping("/project/{id}")
    public ResponseEntity<Project> viewProjectById(@PathVariable("id") Long id){
        Optional<Project> project = projectService.viewProjectByUser(id);
        return new ResponseEntity<Project>(project.get(),HttpStatus.OK);
    }

    // build update comment api
    @PutMapping("/project/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable("id") Long id , Project project){
        Project projectResponse =  projectService.updateProject(project, id);
        return  new ResponseEntity<>(projectResponse, HttpStatus.OK);
    }
    //build delete comment api
    @DeleteMapping("/project/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable("id") Long id, Project project){
        projectService.deleteProject(id);
        return new ResponseEntity<String>("Project deleted successfully", HttpStatus.OK);
    }
}
