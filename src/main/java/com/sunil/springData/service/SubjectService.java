package com.sunil.springData.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.sunil.springData.model.Book;
import com.sunil.springData.model.Subject;
import com.sunil.springData.repository.BookRepository;
import com.sunil.springData.repository.SubjectRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component
public class SubjectService {

	@Autowired
	SubjectRepository subjectRepository;
	@Autowired
	BookRepository bookRepository;
	@Transactional
	public ModelAndView addSubject(Subject subject) {
		if (!(isValidSubjectID(subject.getSubject()) && isValidName(subject.getSubTitle())
				&& isValidHours(subject.getDurationInHours()))) {
			System.out.println("inside validation for subject");
			return new ModelAndView("Failure");
		}
		if(!subject.getRefIds().isEmpty()) {
		List<String> bookTagSelection = new ArrayList<>(Arrays.asList(subject.getRefIds().split(",")));
		List<Book> bookList = (List<Book>) bookRepository.findAll();
		System.out.println("Book Results-->"+Arrays.toString(bookList.toArray()));
		Set<Book> filteredBookList = bookList.stream()
				.filter(a -> bookTagSelection.contains(Long.toString(a.getBookId()))).collect(Collectors.toSet());
		System.out.println("filteredBookList Results-->"+Arrays.toString(filteredBookList.toArray()));
		System.out.println("subject Results-->"+subject.toString());
		subject.setReferences(filteredBookList);
		}
		
		subjectRepository.save(subject);
		return new ModelAndView("Success");
		
	}
	@Transactional
	public ModelAndView deleteSubject(Subject subject) {
		subjectRepository.delete(subject);
		return new ModelAndView("Success");
	}
	@Transactional
	public ModelAndView searchSubject(String title) {
		List<Subject> subList= new ArrayList<>();
		subList=subjectRepository.findSubjectsBySubTitle(title);
		if(subList.size()==0) {
			ModelAndView modelAndView= new ModelAndView("NoResults");
			return modelAndView;
		}
		else {
		ModelAndView modelAndView= new ModelAndView("SubjectSearchResult");
		modelAndView.addObject("subjectSearchResult", subList);
		return modelAndView;
		}
	}
	
	
	public boolean isValidSubjectID(long id) {
		System.out.println("inside isValidSubjectID method");
		return id > 0 ? true : false;
	}

	public boolean isValidName(String name) {
		
		Pattern namePattern = Pattern.compile("[a-zA-Z\\s]{1,25}");
		Matcher nameMatcher = namePattern.matcher(name);
		return nameMatcher.matches();
	}
	
	public boolean isValidHours(int hours) {
		return hours>=0;
	}
	

}
