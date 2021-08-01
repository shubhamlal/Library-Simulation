package com.library.pojo;

import java.util.Random;

import com.library.Constants;

public class Student implements Runnable {
	
	private int id;
	private Book[] books;
	
	public Student(int id, Book[] books)
	{
		this.id = id;
		this.books = books;
	}
	
	
	@Override
	public void run() {
		
		Random random = new Random();
		
		while(true)
		{
			int bookId = random.nextInt(Constants.NUMBER_OF_BOOKS);
			
			books[bookId].read(this);
		}
		
		
	}
	
	public String toString()
	{
		return "id: "+this.id;
	}
	
	

}
