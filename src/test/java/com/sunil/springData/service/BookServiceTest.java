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
import com.sunil.springData.repository.BookRepository;
import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { BookService.class, Book.class })
public class BookServiceTest {

	@MockBean
	BookRepository bookRepositoryMock;

	@Autowired
	BookService bookService;

	Book validBook = new Book();

	Book invalidBook = new Book();
	List<Book> bookList = new ArrayList<>();

	@Before
	public void setUp() {
		validBook = new Book(1L, "first", 100.0, new Integer(2), LocalDate.of(2014, Month.JANUARY, 1));
		invalidBook = new Book(-1, "***", -1, -2, LocalDate.of(99, Month.JANUARY, 30));
		bookList.add(validBook);
	}

	@Test
	public void TestAddBook_whenValidBook_ThenReturnSuccess() {
		ModelAndView modelAndView = bookService.addBook(validBook);
		assertThat(modelAndView.getViewName(), is("Success"));
		assertThat(modelAndView, isA(ModelAndView.class));
	}

	@Test
	public void TestAddBook_whenInvalidBook_ThenReturnFailure() {
		Mockito.when(bookRepositoryMock.findBooksByTitle("fir")).thenReturn(bookList);
		ModelAndView modelAndView = bookService.addBook(invalidBook);
		assertThat(modelAndView.getViewName(), is("Failure"));
		assertThat(modelAndView, isA(ModelAndView.class));
	}

	@Test
	public void TestDeleteBook_whenValidBook_ThenReturnSuccess() {
		ModelAndView modelAndView = bookService.deleteBook(validBook);
		assertThat(modelAndView.getViewName(), is("Success"));
		assertThat(modelAndView, isA(ModelAndView.class));
	}

	@Test
	public void TestDeleteBook_whenInValidBook_ThenReturnFailure() {
		ModelAndView modelAndView = bookService.deleteBook(invalidBook);
		assertThat(modelAndView.getViewName(), is("Failure"));
		assertThat(modelAndView, isA(ModelAndView.class));
	}

	@Test
	public void TestSeachBook_whenValidBookTitle_ThenReturnSuccess() {

		Mockito.when(bookRepositoryMock.findBooksByTitle("fir")).thenReturn(bookList);
		ModelAndView modelAndView = bookService.searchBook("fir");

		assertThat(modelAndView.getViewName(), is("BookSearchResult"));
		assertThat(modelAndView, isA(ModelAndView.class));
		assertThat(modelAndView.getModel().get("bookSearchResult"), is(bookList));

	}

	@Test
	public void TestSeachBook_whenInvalidBookTitle_ThenReturnFailure() {

		Mockito.when(bookRepositoryMock.findBooksByTitle("fir")).thenReturn(bookList);
		ModelAndView modelAndView = bookService.searchBook("@@@");

		assertThat(modelAndView.getViewName(), is("Failure"));
		assertThat(modelAndView, isA(ModelAndView.class));

	}

	@Test
	public void TestSeachBook_whenValidBookTitle_ThenReturnFailure() {

		Mockito.when(bookRepositoryMock.findBooksByTitle("fir")).thenReturn(new ArrayList<Book>());
		ModelAndView modelAndView = bookService.searchBook("fir");

		assertThat(modelAndView.getViewName(), is("NoResults"));
		assertThat(modelAndView, isA(ModelAndView.class));

	}

	@Test
	public void TestIsValidYear_whenYearLessThan1000_ThenReturnFalse() {
		assertThat(bookService.isValidYear("999"), is(false));

	}

	@Test
	public void TestIsValidHours_whenHoursGreaterThanOrEqualToZero_ThenReturnTrue() {
		assertThat(bookService.isValidHours(10), is(true));

	}

	@Test
	public void TestIsValidHours_whenHoursLesserThanZero_ThenReturnFalse() {
		assertThat(bookService.isValidHours(-10), is(false));

	}

	@Test
	public void TestIsValidBook_whenBookIsNull_ThenReturnFalse() {
		assertThat(bookService.isValidBook(null), is(true));

	}

}
