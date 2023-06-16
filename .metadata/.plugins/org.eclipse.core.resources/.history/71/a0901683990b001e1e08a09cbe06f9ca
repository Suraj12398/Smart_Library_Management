package com.smartlab.dao;

import java.util.List;

import com.smartlab.entity.Book;
import com.smartlab.entity.Feedback;
import com.smartlab.entity.Rental;
import com.smartlab.entity.Student;

public interface StudentDao {
	Student save(Student student);
    Student findByUsername(String username);
    List<Book> findAvailableBooks();
    List<Book> searchBooksByGenre(String genre);
    Rental saveRental(Rental rental);
    boolean updateRental(Rental rental);
    boolean deleteRental(Rental rental);
    Feedback saveFeedback(Feedback feedback);
	List<Book> searchBooksByTitle(String title);
	boolean login(String username);
}
