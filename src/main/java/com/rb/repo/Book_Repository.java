package com.rb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rb.entity.Book;

@Repository
public interface Book_Repository  extends JpaRepository<Book, Integer>{

}
