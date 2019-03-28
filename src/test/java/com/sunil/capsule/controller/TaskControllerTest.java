package com.sunil.capsule.controller;

import org.junit.Test;

import com.sunil.capsule.model.Task;
import com.sunil.capsule.model.User;
import static org.junit.Assert.*;

import org.junit.Before;

public class TaskControllerTest {
	
	TaskController taskController =  new TaskController();
	
	Task task = new Task();
	 int taskId;
	
	@Before
	public void setUp() {
		task = new Task();
		  taskId= 1;
	}
	
	@Test
	public void testAddTask_ShouldReturnTrue() {
		assertEquals(taskController.addTask(task), true);
		
	}
	
	@Test
	public void testEditTask_ShouldReturnTrue() {
		assertEquals(taskController.editTask(task), true);
		
	}

	@Test
	public void testViewTask_ShouldReturnTrue() {
		assertEquals(taskController.viewTask(taskId), true);
		
	}

	@Test
	public void testDeleteTask_ShouldReturnTrue() {
		assertEquals(taskController.deleteTask(task), true);
		
	}

}
