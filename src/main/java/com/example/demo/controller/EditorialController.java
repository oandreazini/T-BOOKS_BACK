package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Editorial;
import com.example.demo.service.EditorialServiceImpl;

@RestController
@RequestMapping("/api")
public class EditorialController {

	@Autowired
	EditorialServiceImpl editorialServiceImpl;
	
	@GetMapping("/editorials")
	public List<Editorial> getAllEditorial() {
		return editorialServiceImpl.listAllEditorial();
	}
	
	@PostMapping("/editorials")
	public Editorial saveEditorial(@RequestBody Editorial pr) {
		return editorialServiceImpl.saveEditorial(pr);
	}
	
	@GetMapping("/editorials/{id}")
	public Editorial getEditorialById(@PathVariable(name="id") Long id) {
		return editorialServiceImpl.editorialById(id);
	}
	
	@PutMapping("/editorials/{id}")
	public Editorial updateEditorial(@PathVariable(name="id") Long id, @RequestBody Editorial pr) {
		Editorial selectedEditorial;
		Editorial updatedEditorial;
		
		selectedEditorial = editorialServiceImpl.editorialById(id);
		
		selectedEditorial.setName(pr.getName());
		selectedEditorial.setBooks(pr.getBooks());
				
		updatedEditorial = editorialServiceImpl.saveEditorial(selectedEditorial);
		
		return updatedEditorial;
	}
	
	@DeleteMapping("/editorials/{id}")
	public void deleteEditorial(@PathVariable(name="id") Long id) {
		editorialServiceImpl.deleteEditorial(id);
	}
}
