package com.oc.users;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.oc.exceptions.UserNotFoundException;

@RestController
public class UserController {

	@Autowired
	UserDaoServices userDaoServices;

	@GetMapping("/users")
	public List<User> allUsers() {
		return userDaoServices.getUsers();
	}

	@GetMapping("/user/{id}")
	public Resource<User> getUser(@PathVariable int id) {
		User user = userDaoServices.getUser(id);
		if(user==null) {
			throw new UserNotFoundException("User not found, id-"+id);
		}
		
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).allUsers());
		resource.add(linkTo.withRel("all-users"));
		
		return resource; 
	}

	@PostMapping("/saveUser")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
		User createdUser = userDaoServices.saveUser(user);
		
		URI location =  ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/{id}").buildAndExpand(createdUser.getId()).toUri();
		
		return ResponseEntity.created(location).build(); 
	}

	@DeleteMapping("/removeUser/{id}")
	public void removeUser(@PathVariable Integer id) {
		User user = userDaoServices.deleteUser(id);
		if(user==null) {
			throw new UserNotFoundException("User not found, id-"+id);
		}
	}
}
