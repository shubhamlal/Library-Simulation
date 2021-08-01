package com.library.pojo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {
	
	private int id;
	private Lock lock;
	
	public Book(int id)
	{
		this.id = id;
		this.lock = new ReentrantLock();
	}
	
	public void read(Student student)
	{
		lock.lock();
		System.out.println(student+" started reading book "+this);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lock.unlock();
		System.out.println(student+" stopped reading book"+this);
		
	}
	
	public String toString()
	{
		return "id:"+this.id;  
		
		
	}

}
