package com.sunil.springData.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertThat;

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

import com.sunil.springData.exception.MenuAppException;
import com.sunil.springData.helper.MenuAppHelper;
import com.sunil.springData.model.Book;
import com.sunil.springData.model.Subject;
import com.sunil.springData.repository.BookRepository;
import com.sunil.springData.repository.SubjectRepository;
import com.sunil.springData.service.BookService;
import com.sunil.springData.service.SubjectService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MenuAppController.class, MenuAppHelper.class, BookService.class, BookRepository.class,
		SubjectService.class, SubjectRepository.class })
public class MenuAppControllerTest {

	@Autowired
	MenuAppController menuAppController;
	@MockBean
	SubjectRepository subjectRepository;
	@MockBean
	BookRepository bookRepository;

	Book validBook = new Book();
	Subject validSubject;
	Subject someSubject;

	List<Subject> subList = new ArrayList<>();
	List<Book> bookList = new ArrayList<>();

	@Before
	public void setUp() {
		validBook = new Book(1L, "first", 100.0, new Integer(2), "2011-11-11");
		validSubject = new Subject(1L, "first", 20, "1");
		someSubject = new Subject(1L, "first", 20, "1");
		subList.add(validSubject);
		bookList.add(validBook);
	}

	@Test
	public void TestGetMenu_ThenReturnMenu() throws MenuAppException {
		ModelAndView modelAndView = menuAppController.getMenu();
		assertThat(modelAndView.getViewName(), is("menu"));
		assertThat(modelAndView, isA(ModelAndView.class));
	}

	@Test
	public void TestGetChoice_whenChoiceIsZero_ThenReturnAddSubject() throws MenuAppException {
		ModelAndView modelAndView = menuAppController.getChoice(0);
		assertThat(modelAndView.getViewName(), is("AddSubject"));
		assertThat(modelAndView, isA(ModelAndView.class));
	}

	@Test
	public void TestGetChoice_whenChoiceIsOne_ThenReturnDeleteSubject() throws MenuAppException {
		ModelAndView modelAndView = menuAppController.getChoice(1);
		assertThat(modelAndView.getViewName(), is("DeleteSubject"));
		assertThat(modelAndView, isA(ModelAndView.class));
	}

	@Test
	public void TestGetChoice_whenChoiceIsTwo_ThenReturnSearchSubject() throws MenuAppException {
		ModelAndView modelAndView = menuAppController.getChoice(2);
		assertThat(modelAndView.getViewName(), is("SearchSubject"));
		assertThat(modelAndView, isA(ModelAndView.class));
	}

	@Test
	public void TestGetChoice_whenChoiceIsThree_ThenReturnAddBook() throws MenuAppException {
		ModelAndView modelAndView = menuAppController.getChoice(3);
		assertThat(modelAndView.getViewName(), is("AddBook"));
		assertThat(modelAndView, isA(ModelAndView.class));
	}

	@Test
	public void TestGetChoice_whenChoiceIsFour_ThenReturnDeleteBook() throws MenuAppException {
		ModelAndView modelAndView = menuAppController.getChoice(4);
		assertThat(modelAndView.getViewName(), is("DeleteBook"));
		assertThat(modelAndView, isA(ModelAndView.class));
	}

	@Test
	public void TestGetChoice_whenChoiceIsFour_ThenReturnSearchBook() throws MenuAppException {
		ModelAndView modelAndView = menuAppController.getChoice(5);
		assertThat(modelAndView.getViewName(), is("SearchBook"));
		assertThat(modelAndView, isA(ModelAndView.class));
	}

	@Test
	public void TestAddBook_ThenReturnSuccess() throws MenuAppException {
		ModelAndView modelAndView = menuAppController.addBook(validBook);
		assertThat(modelAndView.getViewName(), is("Success"));
		assertThat(modelAndView, isA(ModelAndView.class));
	}

	@Test
	public void TestAddSubject_ThenReturnSuccess() throws MenuAppException {
		ModelAndView modelAndView = menuAppController.addSubject(validSubject);
		assertThat(modelAndView.getViewName(), is("Success"));
		assertThat(modelAndView, isA(ModelAndView.class));
	}

	@Test
	public void TestDeleteBook_ThenReturnSuccess() throws MenuAppException {
		ModelAndView modelAndView = menuAppController.deleteBook(validBook);
		assertThat(modelAndView.getViewName(), is("Success"));
		assertThat(modelAndView, isA(ModelAndView.class));
	}

	@Test
	public void TestDeleteSubject_ThenReturnSuccess() throws MenuAppException {
		ModelAndView modelAndView = menuAppController.deleteSubject(validSubject);
		assertThat(modelAndView.getViewName(), is("Success"));
		assertThat(modelAndView, isA(ModelAndView.class));
	}

	@Test
	public void TestSearchSubject_whenStringWithNoData_ThenReturnNoResults() throws MenuAppException {
		Mockito.when(subjectRepository.findSubjectsBySubTitle(Mockito.anyString())).thenReturn(new ArrayList<>());
		ModelAndView modelAndView = menuAppController.searchSubject(someSubject);
		assertThat(modelAndView.getViewName(), is("NoResults"));
		assertThat(modelAndView, isA(ModelAndView.class));
	}

	@Test
	public void TestSearchBook_whenString_ThenReturnNoResults() throws MenuAppException {
		Mockito.when(bookRepository.findBooksByTitle(Mockito.anyString())).thenReturn(bookList);
		ModelAndView modelAndView = menuAppController.searchBook(validBook);

		assertThat(modelAndView.getViewName(), is("BookSearchResult"));
		assertThat(modelAndView, isA(ModelAndView.class));
		assertThat(modelAndView.getModel().get("bookSearchResult"), is(bookList));
	}

}
