package com.example.demo.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@Column(name = "book_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id")
	@SequenceGenerator(name = "book_id", sequenceName = "book_id")
	private long id;
	
	@Column(name = "book_name")
	private String name;
	
	@Column(name = "distributor")
	@OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
	@JoinTable(name = "book_distributor",
			   joinColumns = @JoinColumn(name = "book_id"), 
			   inverseJoinColumns = @JoinColumn(name = "distributor_id"))
	private Set<Distributor> distributor = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "books")
	@JsonIgnore
	private List<Author> authors = new ArrayList<>();
	
}
