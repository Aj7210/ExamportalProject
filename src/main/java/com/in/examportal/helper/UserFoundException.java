package com.in.examportal.helper;

public class UserFoundException extends Exception{

	
	public UserFoundException() {
		super("user with this username already there in database||");
	}
	public UserFoundException(String msg) {
		super(msg);
	}
}
