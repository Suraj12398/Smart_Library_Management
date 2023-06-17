package com.smartlab.dao;

import java.util.List;

import com.smartlab.entity.Book;
import com.smartlab.entity.Feedback;
import com.smartlab.entity.Rental;
import com.smartlab.entity.Student;
import com.smartlab.exception.NoRecordFoundException;
import com.smartlab.exception.SomethingWentWrongException;

public interface LibrarianDao {
//		Librarian save(Librarian librarian);
//	    Librarian findByUsername(String username);
	    Book saveBook(Book book)throws SomethingWentWrongException,NoRecordFoundException;
	    boolean updateBook(Book book)throws SomethingWentWrongException,NoRecordFoundException;
	    List<Book> viewBookAvailable()throws SomethingWentWrongException,NoRecordFoundException;
	    List<Rental> findStudentRentals()throws SomethingWentWrongException,NoRecordFoundException;
	    List<Feedback> findBookFeedbacks()throws SomethingWentWrongException,NoRecordFoundException;
		boolean deleteBook(int id)throws SomethingWentWrongException,NoRecordFoundException;
		List<Student> findByUsername(String username)throws SomethingWentWrongException,NoRecordFoundException;
		List<Student> findAllStudent()throws SomethingWentWrongException,NoRecordFoundException;
		boolean deleteStudent(int id)throws SomethingWentWrongException,NoRecordFoundException;
}
