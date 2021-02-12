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

import com.example.demo.entity.Author;
import com.example.demo.services.AuthorService;

@RestController
@RequestMapping("v1")
public class AuthorController {
	private final AuthorService authorService;
	
	public AuthorController(@Autowired AuthorService authorService) {
		System.out.println("test");
		this.authorService = authorService;
	}
	
	@PostMapping(
			value = "/author/create",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Author> createAuthor(@RequestBody(required = true) Author request) {
		return ResponseEntity.ok(authorService.createAuthor(request));
	}
	
	@GetMapping(
			value = "/author/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Author> getAuthorById(@PathVariable("id") String id){
		Optional<Author> author = authorService.getAuthorById(Long.valueOf(id));
		if(author.isEmpty()) {
			return new ResponseEntity<Author>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(author.get());
	}
	
	@DeleteMapping(
			value = "/author/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteAuthorById(@PathVariable("id") String id){
		authorService.deleteAuthor(Long.valueOf(id));		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(
			value = "/author/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Author> updateAuthor(@RequestBody(required = true) Author request, @PathVariable("id") String id) {
		return ResponseEntity.ok(authorService.updateAuthor(Long.valueOf(id), request));
	}
}
