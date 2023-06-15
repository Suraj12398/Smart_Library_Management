package com.smartlab.dao;

import java.util.ArrayList;
import java.util.List;

import com.smartlab.entity.Book;
import com.smartlab.entity.Feedback;
import com.smartlab.entity.Rental;
import com.smartlab.entity.SessionStd;
import com.smartlab.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class StudentDaoImpl implements StudentDao {

	@Override
	public Student save(Student student) {
		// TODO Auto-generated method stub
		EntityManager em = null;
		EntityTransaction et=null;
		try {
			em = EMUtils.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(student);
			et.commit();
		}catch(PersistenceException ex) {
			System.out.println("Duplicate entry");
			ex.getMessage();
		}finally{
			em.close();
		}
		return student;
	}

	@Override
	public Student findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findAvailableBooks() {
		// TODO Auto-generated method stub
		LibrarianDao ld= new LibrarianDaoImpl();
		return ld.viewBookAvailable();
	}

	@Override
	public List<Book> searchBooksByGenre(String genre) {
		// TODO Auto-generated method stub

		EntityManager em = null;
		List<Book> bookList=new ArrayList<Book>();
		try {
			
			em = EMUtils.getEntityManager();
			Query query=em.createQuery("SELECT b From Book b where b.genre LIKE :genre");
			query.setParameter("genre", "%"+genre +"%");
			bookList= query.getResultList();
			EntityTransaction et = em.getTransaction();
			
		}catch(PersistenceException ex) {
			ex.printStackTrace();
		}finally{
			em.close();
		}

return bookList;
	}
	@Override
	public List<Book> searchBooksByTitle(String title) {
		// TODO Auto-generated method stub

		EntityManager em = null;
		List<Book> bookList=new ArrayList<Book>();
		try {
			
			em = EMUtils.getEntityManager();
			Query query=em.createQuery("SELECT b From Book b where b.title LIKE :title");
			query.setParameter("title", "%"+title+"%");
			bookList= query.getResultList();
			EntityTransaction et = em.getTransaction();
			
		}catch(PersistenceException ex) {
			ex.printStackTrace();
		}finally{
			em.close();
		}

return bookList;
	}
	@Override
	public Rental saveRental(Rental rental) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateRental(Rental rental) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRental(Rental rental) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Feedback saveFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean login(String username) {
		EntityManager em = null;
		try {
			SessionStd currentStd=new SessionStd();
			em = EMUtils.getEntityManager();
			Student std = em.find(Student.class,username);
			
			if(std.equals(null)) {
				System.out.println("Please enter Valid Student Id");
				return false;
			}
			EntityTransaction et = em.getTransaction();
			et.begin();
			currentStd.setCurrentUser(std);
			et.commit();
		}catch(PersistenceException ex) {
				ex.getMessage();
		}finally{
			em.close();
		}
		return true;


	}

}
