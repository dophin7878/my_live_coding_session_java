package com.mylive.springcodingsession.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/myAPI")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(path= "/users", produces= MediaType.APPLICATION_JSON_VALUE)
	public List<User> retrieveAllUsers() {
		return userService.retrieveAllUsers();
	}
	
	@GetMapping(path="/user/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
	public Optional<User> retrieveUser(@PathVariable("id") int id) {
		return userService.retrieveUser(id);
	}

	@PostMapping(path="/user", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
}
