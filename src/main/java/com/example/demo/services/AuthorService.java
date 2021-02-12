package com.example.demo.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Author;
import com.example.demo.repositories.AuthroRepository;

@Service
public class AuthorService {
	
private final AuthroRepository authorRepository;
	
	public AuthorService(@Autowired AuthroRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	@Transactional
	public Author createAuthor(Author request) {
		return authorRepository.save(request);
	}
	
	@Transactional
	public void deleteAuthor(long id) {
		authorRepository.deleteById(id);
	}
	
	public Optional<Author> getAuthorById(long id) {
		return authorRepository.findById(id);
	}
	
	@Transactional
	public Author updateAuthor(long id, Author updateAuthor) {
		updateAuthor.setAuthor_id(id);
		return authorRepository.save(updateAuthor);
	}
}
