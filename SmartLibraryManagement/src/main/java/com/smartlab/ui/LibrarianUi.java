package com.smartlab.ui;

import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

import com.smartlab.dao.LibrarianDao;
import com.smartlab.dao.LibrarianDaoImpl;
import com.smartlab.entity.Book;
import com.smartlab.entity.Feedback;
import com.smartlab.entity.Rental;
import com.smartlab.entity.Student;
import com.smartlab.exception.NoRecordFoundException;
import com.smartlab.exception.SomethingWentWrongException;
import com.smartlab.service.LibrarianService;
import com.smartlab.service.LibrarianServiceImpl;

public class LibrarianUi {

	private static void addBook(Scanner sc)  {
		// TODO Auto-generated method stub		
		System.out.println("Enter Book Title");
		String title=sc.next();
		System.out.println("Enter Book Author");
		String author=sc.next();
		System.out.println("Enter Genre of Book");
		String genre=sc.next();	
		Book book=new Book(title,author,genre,true, null);
		
//		*******Dummy Data **********
//		Book book=new Book("5 am Club","Robin Sharma","Self help",true, null);
//		Book book1=new Book("ikigai","Hector Fracia","self help",true, null);
//		Book book2=new Book("fight club","remo wadro","adventures",true, null);
//		Book book3=new Book("The Myth","harry compo","fantacy",true, null);
//		Book book4=new Book("jersey","MS Dhoni","adventures",true, null);
		LibrarianService ls=new LibrarianServiceImpl();
		
		try {
			ls.addBook(book);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	private static void updateBook(Scanner sc)  {
		// TODO Auto-generated method stub
		System.out.println("Enter Id of Book");
		int id=sc.nextInt();
//		sc.next();
		System.out.println("Enter Book Title");
		String title=sc.nextLine();
		sc.next();
		System.out.println("Enter Book Author Name");
		String author=sc.nextLine();
		sc.next();
		System.out.println("Enter Genre of Book");
		String genre=sc.nextLine();
		sc.next();
		System.out.println("Enter y if Available else Enter Anything");
		String av=sc.next();
		sc.next();
		boolean available=false;
		if(av.equals("y")) {
			available=true;
		}
		
		Book book=new Book(title,author,genre,available, null);
		
		book.setBookId(id);
		LibrarianService ls=new LibrarianServiceImpl();
		
		
		try {
			boolean t=ls.updateBookInformation(book);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void deleteBook(Scanner sc) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter Id of Book you want to be deleted");
		int id=sc.nextInt();
		System.out.println("Are You Sure You want to Delete Your Account");
		System.out.println("Enter y for confirmation enter n if not want to delete");
		String cnf=sc.next();
		if(cnf.equals("y")) {
		LibrarianDao ld=new LibrarianDaoImpl();
		try {
			if(ld.deleteBook(id)) {
				System.out.println("Deleted Successfully");
				LibrarianUi.main(null);
			}else{
				System.out.println("Book Not Found");
			}
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else if (cnf.equals("n")) {
			System.out.println("Thank you so much");
		}else {
			System.out.println("Invalid Selection");
			deleteBook(sc);
		}
	}
	
	private static void viewList() {
		// TODO Auto-generated method stub
		
		LibrarianDao ld=new LibrarianDaoImpl();
		List<Book> bookList = null;
		try {
			bookList = ld.viewBookAvailable();
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommandLineTable st = new CommandLineTable();
		st.setShowVerticalLines(true);
		System.out.println("\n");
		st.setHeaders("Id", "Title", "Author","Genre","Feedbacks");

//	
		for(Book b:bookList) {
			String str="";
			StringJoiner joiner = new StringJoiner(", "); 
			b.getFeedbacks().forEach(a -> joiner.add(a.getComment()));

			String feedbacksString = joiner.toString();
			str += feedbacksString + " ";
			st.addRow(""+b.getBookId(), b.getTitle() , b.getAuthor() , b.getGenre(),str);
			
			}
		st.print();
		System.out.println();  

	}
	
	private static void findRentals() {
		// TODO Auto-generated method stub
		LibrarianDao ld=new LibrarianDaoImpl();
		
		List<Rental> rentL = null;
		try {
			rentL = ld.findStudentRentals();
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommandLineTable st = new CommandLineTable();
		st.setShowVerticalLines(true);
		System.out.println("\n");
		st.setHeaders("Id", "Student Name", "Book Title","Fine","Rental Date","Return Date");
		for(Rental f:rentL) {
			st.addRow(""+f.getRentalId(),f.getStudent().getStudentName(),f.getBook().getTitle(),""+f.getFine(),""+f.getRentalDate(),""+f.getReturnDate());
		}
		st.print();
	}
	private static void findfeedback(){
		// TODO Auto-generated method stub
		LibrarianDao ld=new LibrarianDaoImpl();
		List<Feedback> feedList = null;
		try {
			feedList = ld.findBookFeedbacks();
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommandLineTable st = new CommandLineTable();
		st.setShowVerticalLines(true);
		System.out.println("\n");
		st.setHeaders("Feedback Id","Student Name", "Book Title","Feedback","Rating");
		for(Feedback f:feedList) {
			st.addRow(f.getFeedbackId()+"",f.getStudent().getStudentName(),f.getBook().getTitle(),f.getComment(),f.getRating()+"");
		}
		st.print();
		
	}
	private static void findStudentbyUsername(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Enter Username");
		String username=sc.next();
		
		LibrarianDao ld=new LibrarianDaoImpl();
		List<Student> stdList = null;
		try {
			stdList = ld.findByUsername(username);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommandLineTable st = new CommandLineTable();
		st.setHeaders("Id","Student Name","Username","Feedback","Fine");
		st.setShowVerticalLines(true);
		System.out.println("\n");
		
		for(Student s:stdList) {
			
			String str="";
			String str1="";
			StringJoiner joiner = new StringJoiner(", "); 
			StringJoiner joiner1 = new StringJoiner(", "); 
			s.getRentals().forEach(a->joiner1.add(a.getFine()+""));
			s.getFeedbacks().forEach(a -> joiner.add(a.getComment()));
			
			String feedbacksString = joiner.toString();
			str += feedbacksString + " ";
			String rentalString = joiner1.toString();
			str1 += rentalString + " ";
			
			st.addRow(s.getStudentId()+"",s.getStudentName(),s.getUsername(),str,str1);
			System.out.println(s.toString());
		}
		st.print();
	}
	
	private static void findAllStudent() {
		// TODO Auto-generated method stub
		LibrarianDao ld=new LibrarianDaoImpl();
		List<Student> stdList = null;
		try {
			stdList = ld.findAllStudent();
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommandLineTable st = new CommandLineTable();
		st.setHeaders("Id","Student Name","Username","Feedback","Fine");
		st.setShowVerticalLines(true);
		System.out.println("\n");
		
		for(Student s:stdList) {
			
			String str="";
			String str1="";
			StringJoiner joiner = new StringJoiner(", "); 
			StringJoiner joiner1 = new StringJoiner(", "); 
			s.getRentals().forEach(a->joiner1.add(a.getFine()+""));
			s.getFeedbacks().forEach(a -> joiner.add(a.getComment()));
			
			String feedbacksString = joiner.toString();
			str += feedbacksString + " ";
			String rentalString = joiner1.toString();
			str1 += rentalString + " ";
			
			st.addRow(s.getStudentId()+"",s.getStudentName(),s.getUsername(),str,str1);
			System.out.println(s.toString());
		}
		st.print();
		
	}
	
	
	
	private static void deleteStudent(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Enter Id of Student you want to be deleted");
		int id=sc.nextInt();
		LibrarianDao ld=new LibrarianDaoImpl();
		try {
			if(ld.deleteStudent(id)) {
				System.out.println("Deleted Successfully");
			}else{
				System.out.println("Student Not Found");
			}
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
public static void main(String[] args) {
	
	Scanner sc= new Scanner(System.in);
	
	System.out.println("Enter Your Username");
	String username=sc.next();
	if(username.equals("admin")){
		System.out.println("Enter Your Password");
		String password=sc.next();
		if(password.equals("admin")) {
			System.out.println("Welcome Admin");
			String choice = "0";
			do {
				System.out.println("1. Add Book");
				System.out.println("2. Update Book");
				System.out.println("3. Delete Book");
				System.out.println("4. View List of Book");
				System.out.println("5. Show all Rentals");
				System.out.println("6. Show all Feedbacks");
				System.out.println("7. Show Student By Username");
				System.out.println("8. Show All Student");
				System.out.println("9. Delete Student");
				System.out.println("10. Back");
				System.out.println("0. Exit");
				System.out.print("Enter Selection ");
				choice = sc.next();
				switch(choice) {
					case "1":
						addBook(sc);
						break;
					case "2":
						updateBook(sc);
						break;
					case "3":
						deleteBook(sc);
						break;
					case "4":
						viewList();
						break;
					case "5":
						findRentals();
						break;
					case "6":
						findfeedback();
						break;
					case "7":
						findStudentbyUsername(sc);
						break;
					case "8":
						findAllStudent();
						break;
					case "9":
						deleteStudent(sc);
						break;
					case "10":
						MainLab.main(null);
						break;
					case "0":
						System.out.println("Thanks for using the services");
						System.exit(0);
						break;
					default:
						System.out.println("Invalid Selection, try again");
				}
			}while(choice != "0");
			sc.close();
			
		}else {
			System.out.println("Invalid Password");
			main(null);
		}
	}else {
		System.out.println("Invalid Username");
		main(null);
	}
	
	
	
}



	
}

