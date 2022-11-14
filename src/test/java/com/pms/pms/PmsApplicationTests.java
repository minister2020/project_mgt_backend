package com.pms.pms;


import com.pms.pms.Controller.ProjectController;
import com.pms.pms.Dto.ProjectDto;
import com.pms.pms.Entity.Project;
import com.pms.pms.Entity.User;
import com.pms.pms.service.projectService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.when;

@SpringBootTest
class PmsApplicationTests {

	@Mock
	projectService projectService;
	@InjectMocks
	ProjectController projectController;
	@Test
	@Order(1)
	public void test_viewAllProject(){
		List<Project> project = new ArrayList<>();
		project.add(new Project(1L,"title","description", User.builder().build()));
		project.add(new Project(2L,"topic","human being", User.builder().build()));
		project.add(new Project(3L,"work","discriptive", User.builder().build()));
		when(projectService.viewAllProject()).thenReturn(project);
		ResponseEntity<List<Project>> outPut = (ResponseEntity<List<Project>>) projectController.viewAllProject();
//		assertEquals(HttpStatus.FOUND, outPut.getStatusCode());
		assertEquals(3,outPut.getBody().size());
	}
	@Test @Order(2)
	public void test_viewProjectByUser(){
		Project project = new Project(4L,"Argentina","Bueno Aires", User.builder().id(3L).build());
		when(projectService.viewProjectByUser(project.getUser().getId())).thenReturn(Optional.of(project));
		ResponseEntity<Project> outPut = projectController.viewProjectById(project.getId());
		assertEquals(HttpStatus.OK, outPut.getStatusCode());
		assertEquals(project, outPut.getBody().getId());
	}

//	@Test @Order(3)
//	public void test_uploadProject(){
//		Project project = new Project(6L,"city","Nigerian", User.builder().build());
//		when(projectService.uploadProject(project).thenReturn();
//		ResponseEntity<Project> outPut = projectController.uploadProject(project);
//		assertEquals(HttpStatus.CREATED, outPut.getStatusCode());
//		assertEquals(project, outPut.getBody());
//	}



	@Test
	void contextLoads() {
	}

}
