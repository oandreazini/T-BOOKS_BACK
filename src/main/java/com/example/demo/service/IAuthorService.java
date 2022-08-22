package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Author;

public interface IAuthorService {

	/**
	 * Lists all the Author
	 * @return
	 */
	public List<Author> listAllAuthors();

	/**
	 * Saves an Author
	 * @param p
	 * @return
	 */
	public Author saveAuthor(Author a);

	/**
	 * Gets the Box by ID
	 * @param id
	 * @return
	 */
	public Author authorById(Long id);

	/**
	 * Updates the Author
	 * @param p
	 * @return
	 */
	public Author updateAuthor(Author a);

	/**
	 * Deletes the Author
	 * @param id
	 */
	public void deleteAuthor(Long id);

}
