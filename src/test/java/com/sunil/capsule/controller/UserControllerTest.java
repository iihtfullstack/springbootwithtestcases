package com.sunil.capsule.controller;

import org.junit.Test;
import com.sunil.capsule.model.User;
import static org.junit.Assert.*;

import org.junit.Before;

public class UserControllerTest {
	
	UserController userController =  new UserController();
	
	User user = new User();
	 String userName;
	
	@Before
	public void setUp() {
		 user = new User();
		  userName= "testuser";
	}
	
	@Test
	public void testAddUser_ShouldReturnTrue() {
		assertEquals(userController.addUser(user), true);
		
	}
	
	@Test
	public void testEditUser_ShouldReturnTrue() {
		assertEquals(userController.editUser(user), true);
		
	}

	@Test
	public void testViewUser_ShouldReturnTrue() {
		assertEquals(userController.viewUser(userName), true);
		
	}

	@Test
	public void testDeleteUser_ShouldReturnTrue() {
		assertEquals(userController.deleteUser(user), true);
		
	}

}
