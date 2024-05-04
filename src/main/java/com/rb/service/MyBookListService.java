package com.rb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rb.entity.MyBookList;
import com.rb.repo.MyBook_Repository;

@Service
public class MyBookListService {
	
	@Autowired
	MyBook_Repository books;
	
	public void saveMyBook(MyBookList book) {
		books.save(book);
	}
	
	public List<MyBookList> getAllMyBookList(){
		return books.findAll();
	}
	
	public void deleteById(int id) {
		books.deleteById(id);
	}

}
