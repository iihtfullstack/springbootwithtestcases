package com.sunil.capsule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sunil.capsule.model.Task;

@Controller
@RequestMapping(value ="/task")
public class TaskController {

	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public  boolean addTask( Task task)  {
		return true;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	public boolean editTask(Task task)  {
		return true;
	}

	@RequestMapping(value = "/view",method = RequestMethod.GET)
	public boolean viewTask(int taskId)  {
		return true;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public boolean deleteTask(Task task)  {
		return true;
	}

}
