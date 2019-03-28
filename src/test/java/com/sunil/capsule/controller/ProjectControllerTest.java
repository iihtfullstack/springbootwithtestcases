package com.sunil.capsule.controller;

import org.junit.Test;
import com.sunil.capsule.model.Project;
import static org.junit.Assert.*;

import org.junit.Before;

public class ProjectControllerTest {
	
	ProjectController projectController =  new ProjectController();
	
	Project project = new Project();
	 int projectId;
	
	@Before
	public void setUp() {
		 project = new Project();
		  projectId= 1;	}
	
	@Test
	public void testAddProject_ShouldReturnTrue() {
		assertEquals(projectController.addProject(project), true);
		
	}
	
	@Test
	public void testEditProject_ShouldReturnTrue() {
		assertEquals(projectController.editProject(project), true);
		
	}

	@Test
	public void testViewProject_ShouldReturnTrue() {
		assertEquals(projectController.viewProject(projectId), true);
		
	}

	@Test
	public void testDeleteProject_ShouldReturnTrue() {
		assertEquals(projectController.deleteProject(project), true);
		
	}

}
