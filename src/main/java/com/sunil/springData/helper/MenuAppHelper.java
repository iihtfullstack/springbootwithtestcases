package com.sunil.springData.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.sunil.springData.exception.MenuAppException;
import com.sunil.springData.menu.UserMenu;



@Component
public class MenuAppHelper {

	public ModelAndView displayMenuOptions(int choice) throws MenuAppException {

		if (choice < 0 || choice > UserMenu.EXIT.ordinal()) {
			System.out.println("Invalid Choice...");

		}
		UserMenu selectedChoice = UserMenu.values()[choice];
		switch (selectedChoice) {
		case ADD_SUBJECT:
			return new ModelAndView("AddSubject");
		case DELETE_SUBJECT:
			return new ModelAndView("DeleteSubject");

		case SEARCH_SUBJECT:

			return new ModelAndView("SearchSubject");

		case ADD_BOOK:
			return new ModelAndView("AddBook");

		case DELETE_BOOK:
			return new ModelAndView("DeleteBook");

		case SEARCH_BOOK:
			return new ModelAndView("SearchBook");

		case EXIT:
			System.out.println("Good Bye");
			System.exit(0);
			break;
		}
		return null;

	}



}
