package com.smartlab.ui;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.smartlab.dao.StudentDao;
import com.smartlab.dao.StudentDaoImpl;
import com.smartlab.entity.Book;
import com.smartlab.entity.Feedback;
import com.smartlab.entity.Rental;
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
		Student std1=new Student("Suraj Deosarkar","sd","sd",new ArrayList<Rental>());
		Student std2=new Student("sumit kumar","sk","sk",new ArrayList<Rental>());
		Student std3=new Student("Pavan Deshmukh","pd","pd",new ArrayList<Rental>());
		Student std4=new Student("Pankaj Shinde","ps","ps",new ArrayList<Rental>());
		Student std5=new Student("Pankaj Anand","pa","pa",new ArrayList<Rental>());
		StudentDao ls=new StudentDaoImpl();
		
		
		Student t=ls.save(std1);
		ls.save(std2);
		ls.save(std3);
		ls.save(std4);
		ls.save(std5);
		if(t==null) {
			System.out.println("no Student added");
		}else {
			System.out.println("Student added successfull");
		}
		
	}
	private static void loginStudent() {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
//		
		System.out.println("Enter Your Username");
		String username=sc.next();
		System.out.println("Enter Your Password");
		String password=sc.next();
		
		
//		String username="sk";
//		String password="sk";
		
		StudentDao ls=new StudentDaoImpl();
	ls.login(username,password);
		
		
		System.out.println("Welcome "+ SessionStd.getCurrentStd().getStudentName());
		int choice = 0;
		do {
			System.out.println("1. List of Book Available");
			System.out.println("2. Search Book by Genre");
			System.out.println("3. Search Book by Title");
			System.out.println("4. Rent a Book");
			System.out.println("5. Return Book");
			System.out.println("6. Give Feedback for Book");
//			System.out.println("7. Delete Book");
//			System.out.println("8. View List of Book");
			System.out.println("0. Exit");
			System.out.print("Enter Selection ");
			choice = sc.nextInt();
			switch(choice) {
				case 1:
					availableBook();
					break;
				case 2:
					searchByGenre();
					break;
				case 3:
					searchByTitle();
					break;
				case 4:
					bookRent();
					break;
				case 5:
					returnBook();
					break;
				case 6:
					giveFeedback();
					break;
//				case 7:
//					deleteBook(sc);
//					break;
//				case 8:
//					viewList();
//					break;
				case 0:
					System.out.println("Thanks for using the services");
					break;
				default:
					System.out.println("Invalid Selection, try again");
			}
		}while(choice != 0);
		sc.close();
		
	}
	private static void bookRent() {
		// TODO Auto-generated method stub
		StudentDao ls=new StudentDaoImpl();
		ls.findAvailableBooks().forEach(a->System.out.println(a));
		
		int id=2;
		StudentDao st=new StudentDaoImpl();
		Book book=st.findBookById(id);

		Rental rental=new Rental(SessionStd.getCurrentStd(),book,Date.valueOf(LocalDate.now()),null);
		st.saveRental(rental);
	}
	private static void returnBook() {
		// TODO Auto-generated method stub
		StudentDao ls=new StudentDaoImpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Rental Id You want to Return");
		int id=sc.nextInt();
		System.out.println("Enter Book Id You want to Return");
		int idb=sc.nextInt();
//		int id=1;
//		int idb=1;
		StudentDao st=new StudentDaoImpl();
		Book book=st.findBookById(idb);

		Rental rental=new Rental(SessionStd.getCurrentStd(),book,Date.valueOf(LocalDate.now()),Date.valueOf("2023-07-23"));
		
//		Rental rental=new Rental(null,book,Date.valueOf(LocalDate.now()),Date.valueOf(LocalDate.now()));
		rental.setRentalId(id);
		st.updateRental(rental);
		
		
	}
	private static void giveFeedback() {
		// TODO Auto-generated method stub
		StudentDao ls=new StudentDaoImpl();
//		ls.findAvailableBooks().forEach(a->System.out.println(a));
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		StudentDao st=new StudentDaoImpl();
		Book book=st.findBookById(id);
		String msg="well done";
		Feedback feedback=new Feedback(SessionStd.getCurrentStd(),book,msg,10);
		st.saveFeedback(feedback);
	}
	
	
public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	System.out.println("Welcome");
	int choice = 0;
	do {
		System.out.println("1. Sign In");
		System.out.println("2. Register new Student");
		System.out.println("3. Back to Main Menu");
		System.out.println("0. Exit");
		System.out.print("Enter Selection ");
		choice = sc.nextInt();
		switch(choice) {
			case 1:
				loginStudent();
				break;
			case 2:
				registerStudent();
				break;
			case 3:
				MainLab.main(null);
				break;
			
			case 0:
				System.out.println("Thanks for using the services");
				break;
			default:
				System.out.println("Invalid Selection, try again");
		}
	}while(choice != 0);
	sc.close();
			loginStudent();
			
			
			
		
	
	
	
//	availableBook();
//	registerStudent();
//	searchByGenre();
//	searchByTitle();
//	loginStudent();
//	bookRent();
//	returnBook();
//	giveFeedback();
}














}
