package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Editorial;

public interface IEditorialService {
	
	/**
	 * Lists all the Editorial
	 * @return
	 */
	public List<Editorial> listAllEditorial();
	
	/**
	 * Saves a Editorial
	 * @param pr
	 * @return
	 */
	public Editorial saveEditorial(Editorial pr);
	
	/**
	 * Gets the Editorial by ID
	 * @param id
	 * @return
	 */
	public Editorial editorialById(Long id);
	
	/**
	 * Updates the Editorial
	 * @param pr
	 * @return
	 */
	public Editorial updateEditorial(Editorial pr);
	
	/**
	 * Deletes the Editorial
	 * @param id
	 */
	public void deleteEditorial(Long id);
}
