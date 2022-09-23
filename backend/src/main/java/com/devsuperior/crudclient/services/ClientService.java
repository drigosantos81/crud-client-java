package com.devsuperior.crudclient.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.crudclient.dto.ClientDTO;
import com.devsuperior.crudclient.entities.Client;
import com.devsuperior.crudclient.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	/*
	 * public List<ClientDTO> findAll() { List<Client> list = repository.findAll();
	 * 
	 * return list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
	 * // return list.map(x -> new ClientDTO(x)); }
	 */
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		Page<Client> list = repository.findAll(pageRequest);

		return list.map(x -> new ClientDTO(x));

	}

}