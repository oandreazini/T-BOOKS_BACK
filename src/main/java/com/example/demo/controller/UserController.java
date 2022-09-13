package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.IUserDAO;
import com.example.demo.dto.User;
import com.example.demo.service.UserServiceImpl;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class UserController {

	IUserDAO iUserDAO;

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserController(IUserDAO iUserDAO, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.iUserDAO = iUserDAO;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@GetMapping("/response-entity-builder-with-http-headers")
	public ResponseEntity<String> usingResponseEntityBuilderAndHttpHeaders() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Baeldung-Example-Header", "Value-ResponseEntityBuilderWithHttpHeaders");

		return ResponseEntity.ok().headers(responseHeaders).body("Response with header using ResponseEntity");
	}

	@Autowired
	UserServiceImpl userServiceImpl;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userServiceImpl.listAllUsers();
	}

	@PostMapping("/register")
	public User saveUser(@RequestBody User u) {
		u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
		return userServiceImpl.saveUser(u);
	}

	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable(name = "id") Long id) {
		return userServiceImpl.userById(id);
	}

	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable(name = "id") Long id, @RequestBody User u) {
		User selectedUser;
		User updatedUser;

		selectedUser = userServiceImpl.userById(id);

		selectedUser.setName(u.getName());
		selectedUser.setEmail(u.getEmail());
		selectedUser.setPhone(u.getPhone());
		selectedUser.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
		selectedUser.setRole(u.getRole());
		selectedUser.setLoans(u.getLoans());
		selectedUser.setBooks(u.getBooks());

		updatedUser = userServiceImpl.saveUser(selectedUser);

		return updatedUser;
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable(name = "id") Long id) {
		userServiceImpl.deleteUser(id);
	}
}