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
	AuthorServiceImpl pieceServiceImpl;
	
	@GetMapping("/pieces")
	public List<Author> getAllPieces(){
		return pieceServiceImpl.listAllPieces();
	}
	
	@PostMapping("/pieces")
	public Author savePiece(@RequestBody Author p) {
		return pieceServiceImpl.savePiece(p);
	}
	
	@GetMapping("/pieces/{id}")
	public Author getPieceById(@PathVariable(name="id")Long id) {
		return pieceServiceImpl.pieceById(id);
	}
	
	@PutMapping("/pieces/{id}")
	public Author updatePiece(@PathVariable(name="id")Long id, @RequestBody Author p) {
		Author selectedPiece;
		Author updatedPiece;
		
		selectedPiece = pieceServiceImpl.pieceById(id);
		
		selectedPiece.setName(p.getName());
		selectedPiece.setSupplies(p.getSupplies());
		
		updatedPiece = pieceServiceImpl.savePiece(selectedPiece);
		
		return updatedPiece;
	}
	
	@DeleteMapping("/pieces/{id}")
	public void deletePiece(@PathVariable(name="id")Long id) {
		pieceServiceImpl.deletePiece(id);
	}
}
