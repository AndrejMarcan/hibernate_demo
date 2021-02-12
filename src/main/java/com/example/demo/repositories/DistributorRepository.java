package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Distributor;

@Repository
public interface DistributorRepository extends JpaRepository<Distributor, Long> {

}
