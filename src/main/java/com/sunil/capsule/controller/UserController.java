package com.sunil.capsule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sunil.capsule.model.User;


@Controller
@RequestMapping(value ="/user")
public class UserController {

	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public  boolean addUser( User user)  {
		return true;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	public boolean editUser(User user)  {
		return true;
	}

	@RequestMapping(value = "/view",method = RequestMethod.GET)
	public boolean viewUser(String userName)  {
		return true;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public boolean deleteUser(User user)  {
		return true;
	}

	
	
}
