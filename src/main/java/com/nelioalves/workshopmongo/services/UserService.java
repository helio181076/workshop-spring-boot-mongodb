package com.nelioalves.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.workshopmongo.domain.User;
import com.nelioalves.workshopmongo.repository.UserRepository;
import com.nelioalves.workshopmongo.services.exception.ObjectNotFoundException;
import com.sun.el.stream.Optional;

import java.util.optional;

@Service
public class UserService {
	
	@Autowired
	public UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
		
	}
	
//	public User findById(String id) {
//		User user = repo.findOne(id);
//		if (user == null) {
//		throw new ObjectNotFoundException("Objeto não encontrado");
//		}
//		return user;
//		}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}

}
