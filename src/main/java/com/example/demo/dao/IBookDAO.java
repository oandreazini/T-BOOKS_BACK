package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Book;
import com.example.demo.dto.Usuario;

public interface IBookDAO extends JpaRepository<Book, Long>{
	
	/**
	 * Gets a list of books with the same title as the one given
	 * 
	 * @param title the title
	 * @return the list of books
	 */
	public List<Book> getBooksByTitle(String title);
	
//	public List<Book> findBooksByEditorial(String editorial);
//	
//	public List<Book> findBooksByAuthor(String author);
	
	public List<Book> findBooksByUsuario(Usuario usuario);
}