package com.smartlab.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "librarian")
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "librarian_id")
    private int librarianId;

    @Column(name = "librarian_name")
    private String librarianName;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

   

    // One-to-Many relationship with Book
    @OneToMany(mappedBy = "librarian", cascade = CascadeType.ALL)
    private List<Book> books;



	public Librarian() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Librarian( String librarianName, String username, String password, List<Book> books) {
		super();
//		this.librarianId = librarianId;
		this.librarianName = librarianName;
		this.username = username;
		this.password = password;
		this.books = books;
	}



	public int getLibrarianId() {
		return librarianId;
	}



//	public void setLibrarianId(int librarianId) {
//		this.librarianId = librarianId;
//	}



	public String getLibrarianName() {
		return librarianName;
	}



	public void setLibrarianName(String librarianName) {
		this.librarianName = librarianName;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public List<Book> getBooks() {
		return books;
	}



	public void setBooks(List<Book> books) {
		this.books = books;
	}



	@Override
	public String toString() {
		return "Librarian [librarianId=" + librarianId + ", librarianName=" + librarianName + ", username=" + username
				+ ", password=" + password + ", books=" + books + "]";
	}

    
}
