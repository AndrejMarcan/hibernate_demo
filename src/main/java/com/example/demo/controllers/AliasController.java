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

import com.example.demo.entity.Alias;
import com.example.demo.services.AliasService;

@RestController
@RequestMapping(value = "v1")
public class AliasController {
	
	private final AliasService aliasService;

	public AliasController(@Autowired AliasService aliasService) {
		super();
		this.aliasService = aliasService;
	}
	
	@PostMapping(
			value = "/alias/create",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Alias> createAlias(@RequestBody(required = true) Alias request) {
		return ResponseEntity.ok(aliasService.createAlias(request));
	}
	
	@GetMapping(
			value = "/alias/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Alias> getAliasById(@PathVariable("id") String id){
		Optional<Alias> alias = aliasService.getAliasById(Long.valueOf(id));
		if(alias.isEmpty()) {
			return new ResponseEntity<Alias>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(alias.get());
	}
	
	@DeleteMapping(
			value = "/alias/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteAliasById(@PathVariable("id") String id){
		aliasService.deleteAlias(Long.valueOf(id));		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(
			value = "/alias/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Alias> updateAlias(@RequestBody(required = true) Alias request, @PathVariable("id") String id) {
		return ResponseEntity.ok(aliasService.updateAlias(Long.valueOf(id), request));
	}
}
