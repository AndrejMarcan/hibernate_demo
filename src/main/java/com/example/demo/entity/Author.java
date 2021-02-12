package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "authors")
public class Author {
	
	@Id
	@Column(name = "author_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id")
	@SequenceGenerator(name = "author_id", sequenceName = "author_id")
	private long author_id;
	
	@Column(name = "name")
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "alias_id")
	private Alias alias;
	
	@ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinTable(
        name = "author_book",
        joinColumns = { @JoinColumn(name = "author_id", updatable = true, nullable = true) }, 
        inverseJoinColumns = { @JoinColumn(name = "book_id", updatable = true, nullable = true) }
    )
	private List<Book> books = new ArrayList<>();
}
