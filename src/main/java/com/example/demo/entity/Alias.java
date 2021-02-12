package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "alias")
public class Alias {
	@Id
	@Column(name = "alias_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alias_id")
	@SequenceGenerator(name = "alias_id", sequenceName = "alias_id")
	private long id;
	
	@Column(name = "name")
	private String name;
}
