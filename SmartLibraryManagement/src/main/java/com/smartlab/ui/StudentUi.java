package com.smartlab.ui;

import java.util.List;

import com.smartlab.dao.LibrarianDao;
import com.smartlab.dao.LibrarianDaoImpl;
import com.smartlab.dao.StudentDao;
import com.smartlab.dao.StudentDaoImpl;
import com.smartlab.entity.Book;
import com.smartlab.entity.SessionStd;
import com.smartlab.entity.Student;

public class StudentUi {
	
	
	private static void availableBook() {
		// TODO Auto-generated method stub
		StudentDao sd=new StudentDaoImpl();
		
		List<Book> bookList=sd.findAvailableBooks();
		
		for(Book b:bookList) {
			System.out.println(b.toString());
		}
		
	}
	
	private static void searchByGenre() {
		// TODO Auto-generated method stub
StudentDao sd=new StudentDaoImpl();
		String genre="t";
		List<Book> bookList=sd.searchBooksByGenre(genre);
		
		if(bookList.size()==0) {
			System.out.println("No Book Available");
		}else {
			for(Book b:bookList) {
				System.out.println(b.toString());
			}	
		}
		
		
	}
	private static void searchByTitle() {
		// TODO Auto-generated method stub
		StudentDao sd=new StudentDaoImpl();
		String title="club";
		List<Book> bookList=sd.searchBooksByTitle(title);
		
		if(bookList.size()==0) {
			System.out.println("No Book Available");
		}else {
			for(Book b:bookList) {
				System.out.println(b.toString());
			}	
		}
		
	}
	private static void registerStudent() {
		// TODO Auto-generated method stub
		System.out.println("PLease Add Student");
//		Book book=new Book("ikigai","Hector Fracia","tan",false, null);
		Student std=new Student("Suraj Deosarkar","S","s",null);
		StudentDao ls=new StudentDaoImpl();
		Student t=ls.save(std);
		if(t==null) {
			System.out.println("no Student added");
		}else {
			System.out.println("Student added successfull");
		}
		
	}
	private static void loginStudent() {
		// TODO Auto-generated method stub
		String user="s";
		StudentDao ls=new StudentDaoImpl();
		ls.login(user);
		System.out.println(ls.login(user));
		
	}
public static void main(String[] args) {
//	availableBook();
//	registerStudent();
//	searchByGenre();
//	searchByTitle();
	loginStudent();
}









}
