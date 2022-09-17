package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Usuario;


public interface IUserService {

	/**
	 * Lists all the User
	 * @return
	 */
	public List<Usuario> listAllUsers();

	/**
	 * Saves an User
	 * @param p
	 * @return
	 */
	public Usuario saveUser(Usuario a);

	/**
	 * Gets the User by ID
	 * @param id
	 * @return
	 */
	public Usuario userById(Long id);

	/**
	 * Updates the User
	 * @param p
	 * @return
	 */
	public Usuario updateUser(Usuario a);

	/**
	 * Deletes the User
	 * @param id
	 */
	public void deleteUser(Long id);
}
