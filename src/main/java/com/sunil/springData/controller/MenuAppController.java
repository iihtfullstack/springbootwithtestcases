package com.sunil.springData.controller;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sunil.springData.exception.MenuAppException;
import com.sunil.springData.helper.MenuAppHelper;
import com.sunil.springData.model.Book;
import com.sunil.springData.model.Subject;
import com.sunil.springData.service.BookService;
import com.sunil.springData.service.SubjectService;


@Controller
public class MenuAppController {
	@Autowired
	MenuAppHelper menuAppHelper;
	@Autowired
	BookService bookService;
	@Autowired
	SubjectService subjectService;
	
	@RequestMapping(value = "/options",method = RequestMethod.GET)
	public  ModelAndView getMenu() throws MenuAppException {
		System.out.println("inside getMenu()");
		ModelAndView model = new ModelAndView("menu");
		return model;
	}
	@RequestMapping(value = "/book/choice",method = RequestMethod.POST,  
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
	        produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public  ModelAndView getChoice( int choice) throws MenuAppException {
		return menuAppHelper.displayMenuOptions(choice);
	}
	@RequestMapping(value = "/book",method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
	        produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ModelAndView addBook(Book book) throws MenuAppException {
		book.setPublishDate(LocalDate.parse(book.getDate()));
		System.out.println("inside addBook"+book.toString());
		bookService.addBook(book);
		return new ModelAndView("Success");
	}
	@RequestMapping(value = "/subject",method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
	        produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ModelAndView addSubject(Subject subject) throws MenuAppException {
		System.out.println("inside addSubject"+subject.toString());
		return subjectService.addSubject(subject);
	}

	@RequestMapping(value = "/subject/delete", method = RequestMethod.POST)
	public ModelAndView deleteSubject( Subject subject) throws MenuAppException {
		return subjectService.deleteSubject(subject);
	}

	@RequestMapping(value = "/book/delete", method = RequestMethod.POST)
	public ModelAndView deleteBook(Book book) throws MenuAppException {
		return bookService.deleteBook(book);
	}

	@RequestMapping(value = "/book/search", method = RequestMethod.POST)
	public ModelAndView searchBook( Book book) throws MenuAppException {
		return bookService.searchBook(book.getTitle());
	}

	@RequestMapping(value = "/subject/search", method = RequestMethod.POST)
	public ModelAndView searchSubject(Subject subject) throws MenuAppException {
		return subjectService.searchSubject(subject.getSubTitle());
	}
}
