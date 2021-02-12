package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Author;

@Repository
public interface AuthroRepository extends JpaRepository<Author, Long> {

}
