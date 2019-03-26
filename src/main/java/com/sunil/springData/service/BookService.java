package com.sunil.springData.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.sunil.springData.model.Book;
import com.sunil.springData.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class BookService {
	private List<String> validationErrors;
	@Autowired
	BookRepository bookRepository;
	@Transactional
	public ModelAndView addBook(Book book) {
		if(!isValidBook(book)) {
			return  new ModelAndView("Failure");
		}
		bookRepository.save(book);
		return new ModelAndView("Success");
	}
	@Transactional
	public ModelAndView deleteBook(Book book) {
		if(!isValidCode(book.getBookId())) {
			return  new ModelAndView("Failure");
		}
		bookRepository.delete(book);
		return  new ModelAndView("Success");
	}
	@Transactional
	public ModelAndView searchBook(String title) {
		if(!isValidTitle(title)) {
			System.out.println("inside failure");
			return  new ModelAndView("Failure");
		}
		List<Book> bookList = new ArrayList<Book>();
		bookList=bookRepository.findBooksByTitle(title);
		if(bookList.size()==0) {
			ModelAndView modelAndView= new ModelAndView("NoResults");
			return modelAndView;
		}
		else {
		bookList=bookRepository.findBooksByTitle(title);
		ModelAndView modelAndView= new ModelAndView("BookSearchResult");
		modelAndView.addObject("bookSearchResult", bookList);
		return modelAndView;
	}
	}
	
	
	
	
	
public boolean isValidPrice(double price) {
		
		return price>0;
	}
	public boolean isValidVolume(Integer volume) {
		
		return volume>0;

	}
	public boolean isValidYear(String year) {
		if(Integer.parseInt(year)>1000){
		Pattern namePattern = Pattern.compile("[0-9]{1,4}");
		Matcher nameMatcher = namePattern.matcher(year);
		return nameMatcher.matches();
		}
		return false;
	}
	/*public boolean isValidMonth(int month) {
	
		if(month>0 && month<13) {
		return true;
		}
		return false;
	}
	public boolean isValidDay(int day) {
		
		if(day>0 && day<32) {
		return true;
		}
		return false;
	}*/
	public boolean isValidHours(int hours) {
		return hours>=0;
	}
	public boolean isValidCode(long id) {
		return id>=0;
	}
public boolean isValidTitle(String name) {
		
		Pattern namePattern = Pattern.compile("^${1}|[a-zA-Z\\s]{1,25}");
		Matcher nameMatcher = namePattern.matcher(name);
		return nameMatcher.matches();
	}

	public boolean isValidBook(Book book) {
		validationErrors = new ArrayList<>();
		if (book != null) {
			if (!isValidTitle((book.getTitle()))) {
				validationErrors.add("Invalid book Name");
			}
			if (!isValidPrice(book.getPrice())) {
				validationErrors.add("Invalid price");
			}
			if (!isValidVolume(book.getVolume())) {
				validationErrors.add("Invalid volume");
			}
			if (!isValidYear((Integer.toString(book.getPublishDate().getYear())))) {
				validationErrors.add("Invalid Year");
			}
		/*	if (!isValidMonth(book.getPublishDate().getMonthValue())) {
				validationErrors.add("Invalid month");
			}
			if (!isValidDay(book.getPublishDate().getDayOfMonth())) {
				validationErrors.add("Invalid day");
			}*/
			
		}
		return validationErrors.isEmpty();

	}


}
