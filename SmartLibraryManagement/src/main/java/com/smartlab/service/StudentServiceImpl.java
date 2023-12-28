package com.smartlab.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.smartlab.dao.StudentDaoImpl;
import com.smartlab.entity.Book;
import com.smartlab.entity.Feedback;
import com.smartlab.entity.Rental;
import com.smartlab.entity.Student;
import com.smartlab.exception.NoRecordFoundException;
import com.smartlab.exception.SomethingWentWrongException;

public class StudentServiceImpl implements StudentService {

	StudentDaoImpl sDI=new StudentDaoImpl();
	
	@Override
	public Student registerStudent(String studentName, String username, String password) {
		// TODO Auto-generated method stub
		
		Student std=new Student(studentName, username, password, new ArrayList<Rental>());
		return sDI.save(std);
	}

	@Override
	public String login(String username, String password) {
		// TODO Auto-generated method stub
		try {
			sDI.login(username, password);
			return "LogIn Successfully";
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Not Found";
		
		
	
		
	}

	
	
	
	@Override
	public List<Book> viewAvailableBooks() {
		// TODO Auto-generated method stub
		try {
			return sDI.findAvailableBooks();
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Book>();
	}

	@Override
	public List<Book> searchBooksByCriteria(String criteria) {
		// TODO Auto-generated method stub
		try {
			return sDI.searchBooksByGenre(criteria);
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Book>();
	}

	@Override
	public void rentBook(Student student, Book book) {
		// TODO Auto-generated method stub
		Rental rt=new Rental(student, book, Date.valueOf(LocalDate.now()), null);
		
		try {
			sDI.saveRental(rt);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Feedback provideFeedback(Student student, Book book, String comment, int rating) {
		// TODO Auto-generated method stub
		Feedback fd=new Feedback(student, book, comment, rating);
		
				try {
					sDI.saveFeedback(fd);
					return fd;
				} catch (SomethingWentWrongException | NoRecordFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
	}

	@Override
	public boolean returnBook(Rental rental) {
		// TODO Auto-generated method stub
		try {
			return sDI.updateRental(rental);
			
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Book> searchBooksByTitle(String title) {
		// TODO Auto-generated method stub
		try {
			return sDI.searchBooksByTitle(title);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Book findBookById(int id) {
		// TODO Auto-generated method stub
		try {
			return sDI.findBookById(id);
		} catch (NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	

}
