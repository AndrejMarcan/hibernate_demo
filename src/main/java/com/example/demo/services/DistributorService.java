package com.example.demo.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Distributor;
import com.example.demo.repositories.DistributorRepository;

@Service
public class DistributorService {
private final DistributorRepository distributorRepository;
	
	public DistributorService(@Autowired DistributorRepository distributorRepository) {
		this.distributorRepository = distributorRepository;
	}
	
	@Transactional
	public Distributor createDistributor(Distributor newDist) {
		return distributorRepository.save(newDist);
	}
	
	@Transactional
	public void deleteDistributor(long id) {
		distributorRepository.deleteById(id);
	}
	
	public Optional<Distributor> getDistributorById(long id) {
		return distributorRepository.findById(id);
	}
	
	@Transactional
	public Distributor updateDistributor(long id, Distributor updateDistributor) {
		updateDistributor.setDist_id(id);
		return distributorRepository.save(updateDistributor);
	}
}
