package com.rb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rb.entity.MyBookList;

@Repository
public interface MyBook_Repository extends JpaRepository<MyBookList, Integer> {

}
