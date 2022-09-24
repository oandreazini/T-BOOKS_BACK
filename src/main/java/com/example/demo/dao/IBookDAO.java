package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Book;
import com.example.demo.dto.Usuario;

@Repository
public interface IBookDAO extends JpaRepository<Book, Long> {

	/**
	 * Gets a list of books with the same title as the one given
	 * 
	 * @param title the title
	 * @return the list of books
	 */
	public List<Book> getBooksByTitle(String title);

	/**
	 * Returns a list of books with the given editorial
	 * 
	 * @param editorial
	 * @return list of books
	 */
	public List<Book> findBooksByEditorial(String editorial);

	/**
	 * Returns a list of books with the given author
	 * 
	 * @param author
	 * @return list of books
	 */
	public List<Book> findBooksByAuthor(String author);

	/**
	 * Returns a list of books with the given usuario
	 * 
	 * @param usuario
	 * @return list of books
	 */
	public List<Book> findBooksByUsuario(Usuario usuario);

	/**
	 * Returns a list of books with the given ISBN
	 * 
	 * @param isbn
	 * @return list of books
	 */
	public List<Book> findBooksByIsbn(String isbn);
}