package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Author;
import com.example.demo.dto.Book;
import com.example.demo.dto.Editorial;

public interface IBookService {
	
	/**
	 * Lists all the Books
	 * @return all the books
	 */
	public List<Book> listAllBooks();
	
	/**
	 * Saves a Book
	 * @param b the book to save
	 * @return the book saved
	 */
	public Book saveBook(Book b);
	
	/**
	 * Gets the Book by ID
	 * @param id of the book
	 * @return the book of the ID
	 */
	public Book bookById(Long id);
	
	/**
	 * Updates the Book
	 * @param b the book to update
	 * @return book updated
	 */
	public Book updateBook(Book b);
	
	/**
	 * Deletes the Book
	 * @param id of the book
	 */
	public void deleteBook(Long id);
	
	/**
	 * Gets a list of books with the same Title as the one given
	 * 
	 * @param title the Title
	 * @return the list of books
	 */
	public List<Book> getBooksByTitle(String title);
	
	public List<Book> findBooksByEditorial(Editorial editorial);
	
	public List<Book> findBooksByAuthor(Author author);

}