package com.library;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.library.pojo.Book;
import com.library.pojo.Student;

public class App {

	public static void main(String[] args) {
		
		Student[] students = new Student[Constants.NUMBER_OF_STUDENTS];
		
		Book[] books = new Book[Constants.NUMBER_OF_BOOKS];
		
		ExecutorService pool = Executors.newFixedThreadPool(Constants.NUMBER_OF_STUDENTS);
		try
		{
			for(int i=0;i<Constants.NUMBER_OF_BOOKS;i++){
				books[i]=new Book(i);
			}
			
			for(int i=0;i<Constants.NUMBER_OF_STUDENTS;i++){
				students[i]=new Student(i,books);
				pool.execute(students[i]);
			}					
		}
	catch(Exception e){
		e.printStackTrace();
		pool.shutdown();
	}finally{
		pool.shutdown();
	}
		
		
	}
}
