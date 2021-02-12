package com.example.demo.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(@Autowired BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@Transactional
	public Book createBook(Book newBook) {
		return bookRepository.save(newBook);
	}
	
	@Transactional
	public void deleteBook(long id) {
		bookRepository.deleteById(id);
	}
	
	public Optional<Book> getBookById(long id) {		
		return bookRepository.findById(id);
	}
	
	@Transactional
	public Book updateBook(long id, Book updateBook) {
		updateBook.setId(id);
		return bookRepository.save(updateBook);
	}
}
