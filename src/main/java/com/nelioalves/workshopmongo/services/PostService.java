package com.nelioalves.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.workshopmongo.domain.Post;
import com.nelioalves.workshopmongo.repository.PostRepository;
import com.nelioalves.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}

}


//package com.nelioalves.workshopmongo.services;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.nelioalves.workshopmongo.domain.User;
//import com.nelioalves.workshopmongo.dto.UserDTO;
//import com.nelioalves.workshopmongo.repository.UserRepository;
//import com.nelioalves.workshopmongo.services.exception.ObjectNotFoundException;
////import com.sun.el.stream.Optional;
//
//
//
//@Service
//public class UserService {
//	
//	@Autowired
//	public UserRepository repo;
//	
//	public List<User> findAll(){
//		return repo.findAll();
//		
//	}
//	
////	public User findById(String id) {
////		User user = repo.findOne(id);
////		if (user == null) {
////		throw new ObjectNotFoundException("Objeto não encontrado");
////		}
////		return user;
////		}
//	
//	public User findById(String id) {
//		Optional<User> obj = repo.findById(id);
//		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
//		}
//	
//	public User insert(User obj) {
//		return repo.insert(obj);
//	}
//	
//	public void delete(String id) {
//		findById(id);
//		//return repo.deleteById(id);
//		return;
//	}
//	
//	public User fromDTO(UserDTO objDto) {
//		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
//		
//	}
//
//}
