package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.Author;
import com.example.demo.service.AuthorServiceImpl;


@RestController
@RequestMapping("/api")
public class AuthorController {
	
	@Autowired
	AuthorServiceImpl authorServiceImpl;
	
	@GetMapping("/authors")
	public List<Author> getAllAuthors(){
		return authorServiceImpl.listAllAuthors();
	}
	
	@PostMapping("/authors")
	public Author saveAuthor(@RequestBody Author a) {
		return authorServiceImpl.saveAuthor(a);
	}
	
	@GetMapping("/authors/{id}")
	public Author getAuthorById(@PathVariable(name="id")Long id) {
		return authorServiceImpl.authorById(id);
	}
	
	@PutMapping("/authors/{id}")
	public Author updateAuthor(@PathVariable(name="id")Long id, @RequestBody Author a) {
		Author selectedAuthor;
		Author updatedAuthor;
		
		selectedAuthor = authorServiceImpl.authorById(id);
		
		selectedAuthor.setNameSurname(a.getNameSurname());
		
		updatedAuthor = authorServiceImpl.saveAuthor(selectedAuthor);
		
		return updatedAuthor;
	}
	
	@DeleteMapping("/authors/{id}")
	public void deleteAuthor(@PathVariable(name="id")Long id) {
		authorServiceImpl.deleteAuthor(id);
	}
}
