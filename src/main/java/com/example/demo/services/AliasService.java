package com.example.demo.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Alias;
import com.example.demo.repositories.AliasRepository;

@Service
public class AliasService {
	private final AliasRepository aliasRepository;

	public AliasService(@Autowired AliasRepository aliasRepository) {
		super();
		this.aliasRepository = aliasRepository;
	}
	
	@Transactional
	public Alias createAlias(Alias request) {
		return aliasRepository.save(request);
	}
	
	@Transactional
	public void deleteAlias(long id) {
		aliasRepository.deleteById(id);
	}
	
	public Optional<Alias> getAliasById(long id) {
		return aliasRepository.findById(id);
	}
	
	@Transactional
	public Alias updateAlias(long id, Alias updateAlias) {
		updateAlias.setId(id);
		return aliasRepository.save(updateAlias);
	}
}
