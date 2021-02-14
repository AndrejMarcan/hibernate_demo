package com.example.demo.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.demo.entity.Author;
import com.example.demo.repositories.AuthroRepository;
import com.example.demo.repositories.BookRepository;

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
		/* get author by id */
		Optional<Author> oldAuthorOpt = getAuthorById(id);
		if(oldAuthorOpt.isEmpty()) {
			return null;
		}
		
		Author oldAuthor = oldAuthorOpt.get();
		if(updateAuthor.getName() != null) {
			oldAuthor.setName(updateAuthor.getName());
		}
		
		if(updateAuthor.getAlias() != null) {
			oldAuthor.setAlias(updateAuthor.getAlias());
		}
		
		if(CollectionUtils.isEmpty(updateAuthor.getBooks())) {
			oldAuthor.setBooks(updateAuthor.getBooks());
		}
		
		return authorRepository.save(oldAuthor);
	}
}
