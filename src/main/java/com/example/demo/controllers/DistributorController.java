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

import com.example.demo.entity.Distributor;
import com.example.demo.services.DistributorService;

@RestController
@RequestMapping("v1")
public class DistributorController {
private final DistributorService distributorService;
	
	public DistributorController(@Autowired DistributorService distributorService) {
		this.distributorService = distributorService;
	}
	
	@PostMapping(
			value = "/distributor/create",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Distributor> createDistributor(@RequestBody(required = true) Distributor request) {
		return ResponseEntity.ok(distributorService.createDistributor(request));
	}
	
	@GetMapping(
			value = "/distributor/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Distributor> getDistributorById(@PathVariable("id") String id){
		Optional<Distributor> distributor = distributorService.getDistributorById(Long.valueOf(id));
		if(distributor.isEmpty()) {
			return new ResponseEntity<Distributor>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(distributor.get());
	}
	
	@DeleteMapping(
			value = "/distributor/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteDistributorById(@PathVariable("id") String id){
		distributorService.deleteDistributor(Long.valueOf(id));		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(
			value = "/distributor/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Distributor> updateDistributor(@RequestBody(required = true) Distributor request, @PathVariable("id") String id) {
		return ResponseEntity.ok(distributorService.updateDistributor(Long.valueOf(id), request));
	}
}
