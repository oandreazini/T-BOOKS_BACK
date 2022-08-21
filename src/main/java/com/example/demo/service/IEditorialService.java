package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Editorial;

public interface IEditorialService {
	/**
	 * Lists all the Provider
	 * @return
	 */
	public List<Editorial> listAllProviders();
	
	/**
	 * Saves a Provider
	 * @param pr
	 * @return
	 */
	public Editorial saveProvider(Editorial pr);
	
	/**
	 * Gets the Provider by ID
	 * @param id
	 * @return
	 */
	public Editorial providerById(Long id);
	
	/**
	 * Updates the Provider
	 * @param pr
	 * @return
	 */
	public Editorial updateProvider(Editorial pr);
	
	/**
	 * Deletes the Provider
	 * @param id
	 */
	public void deleteProvider(Long id);
}
