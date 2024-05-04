package com.rb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rb.entity.Book;
import com.rb.repo.Book_Repository;

@Service
public class BookService {

	@Autowired

	Book_Repository book_Repository;

	public void save(Book book) {
		book_Repository.save(book);
	}

	public List<Book> getAllBook() {
		return book_Repository.findAll();
	}

	public Book getBookById(int id) {
		return book_Repository.findById(id).get();
	}

	public void deleteById(int id) {
		book_Repository.deleteById(id);
	}

}
