package com.smartlab.entity;

public class SessionStd {

	private static Student currentStd;

    public static Student getCurrentUser() {
        return currentStd;
    }

    public void setCurrentUser(Student std) {
        currentStd = std;
    }
	
	
}
