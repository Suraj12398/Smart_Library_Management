package com.smartlab.service;

import java.util.List;

import com.smartlab.dao.LibrarianDao;
import com.smartlab.dao.LibrarianDaoImpl;
import com.smartlab.entity.Book;
import com.smartlab.entity.Feedback;
//import com.smartlab.entity.Librarian;
import com.smartlab.entity.Rental;
import com.smartlab.exception.NoRecordFoundException;
import com.smartlab.exception.SomethingWentWrongException;

public class LibrarianServiceImpl implements LibrarianService {

	LibrarianDao ld= new LibrarianDaoImpl();
	
	
//	@Override
//	public Librarian registerLibrarian(String librarianName, String username, String password) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public Librarian login(String username, String password) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Book addBook(Book book) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return ld.saveBook(book);
	}

	@Override
	public boolean updateBookInformation(Book book) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return ld.updateBook(book);
	}

	@Override
	public boolean removeBook(int id) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return ld.deleteBook(id);
	}

	@Override
	public List<Rental> viewStudentRentals() {
		// TODO Auto-generated method stub
		try {
			return ld.findStudentRentals();
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Feedback> viewBookFeedbacks() throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		return ld.findBookFeedbacks();
	}

	

}
