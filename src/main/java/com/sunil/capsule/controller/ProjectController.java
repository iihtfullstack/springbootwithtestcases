package com.sunil.capsule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sunil.capsule.model.Project;

@Controller
public class ProjectController {

	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public  boolean addProject(Project project)  {
		return true;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	public boolean editProject(Project project)  {
		return true;
	}

	@RequestMapping(value = "/view",method = RequestMethod.GET)
	public boolean viewProject(int projectId)  {
		return true;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public boolean deleteProject(Project project)  {
		return true;
	}
}
