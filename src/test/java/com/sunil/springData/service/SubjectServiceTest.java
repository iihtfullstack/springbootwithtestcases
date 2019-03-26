package com.sunil.springData.service;

import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

import com.sunil.springData.model.Book;
import com.sunil.springData.model.Subject;
import com.sunil.springData.repository.BookRepository;
import com.sunil.springData.repository.SubjectRepository;

import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SubjectService.class, Subject.class, Book.class })
public class SubjectServiceTest {

	@MockBean
	SubjectRepository subjectRepositoryMock;

	@MockBean
	BookRepository bookRepositoryMock;

	@Autowired
	SubjectService subjectService;

	Subject validSubject;
	Subject validSubject1;
	Book validBook;
	List<Subject> subList = new ArrayList<>();
	List<Book> bookList = new ArrayList<>();

	Subject invalidSubject;
	Subject invalidSubject1;
	Subject invalidSubject2;

	@Before
	public void setUp() {
		validBook = new Book(1L, "first", 100.0, new Integer(2), LocalDate.of(2014, Month.JANUARY, 1));
		validSubject = new Subject(1L, "first", 20, "1");
		validSubject1 = new Subject(1L, "first", 20, "");
		invalidSubject = new Subject(-1L, "@@@", -1, "");
		invalidSubject1 = new Subject(1L, "@@@", -1, "");
		invalidSubject2 = new Subject(1L, "subject", -1, "");
		subList.add(validSubject);
		bookList.add(validBook);
	}

	@Test
	public void TestAddSubject_whenValidSubject_ThenReturnSuccess() {
		Mockito.when(bookRepositoryMock.findAll()).thenReturn(bookList);
		ModelAndView modelAndView = subjectService.addSubject(validSubject);
		assertThat(modelAndView.getViewName(), is("Success"));
		assertThat(modelAndView, isA(ModelAndView.class));
	}

	@Test
	public void TestAddSubject_whenValidSubjectButEmptyReference_ThenReturnSuccess() {
		ModelAndView modelAndView = subjectService.addSubject(validSubject1);
		assertThat(modelAndView.getViewName(), is("Success"));
		assertThat(modelAndView, isA(ModelAndView.class));
	}

	@Test
	public void TestAddSubject_whenInvalidSubject_ThenReturnFailure() {
		ModelAndView modelAndView = subjectService.addSubject(invalidSubject);
		assertThat(modelAndView.getViewName(), is("Failure"));
		assertThat(modelAndView, isA(ModelAndView.class));
	}

	@Test
	public void TestAddSubject_whenValidSubjectIdInvalidNameValidHours_ThenReturnFailure() {
		ModelAndView modelAndView = subjectService.addSubject(invalidSubject1);
		assertThat(modelAndView.getViewName(), is("Failure"));
		assertThat(modelAndView, isA(ModelAndView.class));
	}

	@Test
	public void TestAddSubject_whenValidSubjectIdValidNameInvalidHours_ThenReturnFailure() {
		ModelAndView modelAndView = subjectService.addSubject(invalidSubject2);
		assertThat(modelAndView.getViewName(), is("Failure"));
		assertThat(modelAndView, isA(ModelAndView.class));
	}

	@Test
	public void TestSearchSubject_whenValidTitle_ThenReturnEmptyResult() {
		Mockito.when(subjectRepositoryMock.findSubjectsBySubTitle("some")).thenReturn(new ArrayList<>());
		ModelAndView modelAndView = subjectService.searchSubject("some");
		assertThat(modelAndView.getViewName(), is("NoResults"));
		assertThat(modelAndView, isA(ModelAndView.class));
	}

	@Test
	public void TestSearchSubject_whenValidTitle_ThenReturnSubjectSearchResult() {
		Mockito.when(subjectRepositoryMock.findSubjectsBySubTitle("fir")).thenReturn(subList);
		ModelAndView modelAndView = subjectService.searchSubject("fir");
		assertThat(modelAndView.getViewName(), is("SubjectSearchResult"));
		assertThat(modelAndView, isA(ModelAndView.class));
		assertThat(modelAndView.getModel().get("subjectSearchResult"), is(subList));
	}

	@Test
	public void TestDeleteSubject_whenValidSubject_ThenReturnSuccess() {
		ModelAndView modelAndView = subjectService.deleteSubject(validSubject);
		assertThat(modelAndView.getViewName(), is("Success"));
		assertThat(modelAndView, isA(ModelAndView.class));
	}

}
