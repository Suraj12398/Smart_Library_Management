package com.smartlab.ui;

import java.util.Scanner;


import com.smartlab.dao.StudentDao;
import com.smartlab.dao.StudentDaoImpl;

public class MainLab {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Scanner sc = new Scanner(System.in);
    	int choice = 0;
    	do {
    		System.out.println("1. Admin Side");
    		System.out.println("2. Student Side");
    		System.out.println("0. Exit");
    		System.out.print("Enter Selection ");
    		choice = sc.nextInt();
    		switch(choice) {
    			case 1:
    				LibrarianUi.main(args);
    				break;
    			case 2:
    				StudentUi.main(args);
    				break;
    			case 0:
    				System.out.println("Thanks for using the services");
    				break;
    			default:
    				System.out.println("Invalid Selection, try again");
    		}
    	}while(choice != 0);
    	sc.close();
    }

		
		
	}
	
	



	

	

	


