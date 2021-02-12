package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.services.BookService;

@RestController
@RequestMapping("v1")
public class BookController {
	
	private final BookService bookService;
	
	public BookController(@Autowired BookService bookService) {
		this.bookService = bookService;
	}
	
	@PostMapping(
			value = "/book/create",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> createBook(@RequestBody(required = true) Book request) {
		return ResponseEntity.ok(bookService.createBook(request));
	}
	
	@GetMapping(
			value = "/book/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> getBookById(@PathVariable("id") String id){
		Optional<Book> book = bookService.getBookById(Long.valueOf(id));
		if(book.isEmpty()) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(book.get());
	}
	
	@DeleteMapping(
			value = "/book/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteBookById(@PathVariable("id") String id){
		bookService.deleteBook(Long.valueOf(id));		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(
			value = "/book/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> updateAuthor(@RequestBody(required = true) Book request, @PathVariable("id") String id) {
		return ResponseEntity.ok(bookService.updateBook(Long.valueOf(id), request));
	}
}
