package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Author;

public interface IAuthorService {
	
	/**
	 * Lists all the Piece
	 * @return
	 */
	public List<Author> listAllPieces();
	
	/**
	 * Saves an Piece
	 * @param p
	 * @return
	 */
	public Author savePiece(Author p);
	
	/**
	 * Gets the Box by ID
	 * @param id
	 * @return
	 */
	public Author pieceById(Long id);
	
	/**
	 * Updates the Piece
	 * @param p
	 * @return
	 */
	public Author updatePiece(Author p);
	
	/**
	 * Deletes the Piece
	 * @param id
	 */
	public void deletePiece(Long id);

}
