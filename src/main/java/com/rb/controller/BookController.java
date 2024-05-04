package com.rb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rb.entity.Book;
import com.rb.entity.MyBookList;
import com.rb.service.BookService;
import com.rb.service.MyBookListService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private MyBookListService myBookListService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/book_register")
	public String bookRegister() {
		return "BookRegister";
	}

	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
		
		List<Book> list =bookService.getAllBook();
		
//		ModelAndView model = new ModelAndView();
//		
//		model.setViewName("bookList");
//		
//		model.addObject("book", list);
		
		return new ModelAndView("bookList","book",list);
	}

	@PostMapping("/save")
	public String saveBook(@ModelAttribute Book book) {
		
		bookService.save(book);
		
		return "redirect:/available_books";
	}

	@GetMapping("/my_books")
	public String getMyBook(Model model) {

		List<MyBookList> list = myBookListService.getAllMyBookList();

		model.addAttribute("book", list);

		return "myBooks";
	}

	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable int id) {

		Book book = bookService.getBookById(id);

		MyBookList mb = new MyBookList(book.getId(), book.getName(), book.getAuthor(), book.getPrice());

		myBookListService.saveMyBook(mb);

		return "redirect:/my_books";

	}

	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable int id, Model model) {

		Book book = bookService.getBookById(id);

		model.addAttribute(book);

		return "bookEdit";
	}

	@RequestMapping("/deletebook/{id}")
	public String deleteBook(@PathVariable int id) {

		bookService.deleteById(id);

		return "redirect:/available_books";

	}

}
