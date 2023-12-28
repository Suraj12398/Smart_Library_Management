package com.smartlab.service;

import java.util.List;

import com.smartlab.entity.Book;
import com.smartlab.entity.Feedback;
import com.smartlab.entity.Rental;
import com.smartlab.entity.Student;
import com.smartlab.exception.NoRecordFoundException;
import com.smartlab.exception.SomethingWentWrongException;

public interface StudentService {
	 	Student registerStudent(String studentName, String username, String password);
	    String login(String username, String password);
	    List<Book> viewAvailableBooks();
	    List<Book> searchBooksByCriteria(String criteria);
	    List<Book> searchBooksByTitle(String title);
	    void rentBook(Student student, Book book);
	    Book findBookById(int id);
	    Feedback provideFeedback(Student student, Book book, String comment, int rating);
//	    void logout(Student student);
		boolean returnBook(Rental rental);
		
}
