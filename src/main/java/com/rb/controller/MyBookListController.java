package com.rb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rb.service.MyBookListService;

@Controller
public class MyBookListController {
	
	@Autowired
	private MyBookListService bookListService;
	
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyBook(@PathVariable int id)
	{
		bookListService.deleteById(id);
		
		return "redirect:/my_books";
	}

}
