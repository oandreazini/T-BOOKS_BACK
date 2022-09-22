package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.IUserDAO;
import com.example.demo.dto.Role;
import com.example.demo.dto.Usuario;
import com.example.demo.service.UserDetailsServiceImpl;

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
	UserDetailsServiceImpl userServiceImpl;

	@GetMapping("/users")
	public List<Usuario> getAllUsers() {
		return userServiceImpl.listAllUsers();
	}

	@PostMapping("/register")
	public Usuario saveUser(@RequestBody Usuario u) {
		Usuario user = new Usuario();
		
		user.setUsername(u.getUsername());
		user.setPhone(u.getPhone());
		user.setEmail(u.getEmail());
		user.setName(u.getName());
		user.setCity(u.getCity());
		user.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
		
		user.addRole(new Role(11));
		
		return userServiceImpl.saveUser(user);
	}

	@GetMapping("/users/{id}")
	public Usuario getUserById(@PathVariable(name = "id") Long id) {
		return userServiceImpl.userById(id);
	}

	@PutMapping("/users/{id}")
	public Usuario updateUser(@PathVariable(name = "id") Long id, @RequestBody Usuario u) {
		Usuario selectedUser;
		Usuario updatedUser;
		
		selectedUser = userServiceImpl.userById(id);

		selectedUser.setName(u.getName());
		selectedUser.setEmail(u.getEmail());
		selectedUser.setPhone(u.getPhone());
		selectedUser.setCity(u.getCity());

		updatedUser = userServiceImpl.saveUser(selectedUser);

		return updatedUser;

	}
	
	@PutMapping("/users/pass/{id}")
	public Usuario updatePass(@PathVariable(name = "id") Long id, @RequestBody Usuario u) {
		Usuario selectedUser;
		Usuario updatedUser;
		
		selectedUser = userServiceImpl.userById(id);

		selectedUser.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));

		updatedUser = userServiceImpl.saveUser(selectedUser);

		return updatedUser;

	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable(name = "id") Long id) {
		userServiceImpl.deleteUser(id);
	}
	
	@GetMapping("/users/username/{username}")
	public Usuario getUsuarioByUsername(@PathVariable(name = "username") String username) {
		return userServiceImpl.getUsuarioByUsername(username);
	}
}