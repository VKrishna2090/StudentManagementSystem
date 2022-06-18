package com.example.db;

public class Validations {
	public static int isRnoValid(int rno) {
		if(rno<=0) {
			return 1;
		}
		if(DbHandler.getStudentForUpdate(rno) != null) {
			return 2;
		}
		
		return 0;
	}
	
	public static int isNameValid(String name) {
		if (name.length()<2 || name.length()>30) {
			return 1; 
		} 
		for(int i=0; i<name.length(); i++) {
			char ch = name.charAt(i);
			if(!Character.isLetter(ch) && ch!=' ') {
				return 2;
			}
		}
		return 0;
	}

	public static int isMarksValid(double m) {
		if(m<0 || m>100) {
			return 1;
		}
		
		return 0;
	}
}