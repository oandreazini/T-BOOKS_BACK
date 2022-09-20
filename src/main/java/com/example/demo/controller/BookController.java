package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.Book;
import com.example.demo.dto.Usuario;
import com.example.demo.service.BookServiceImpl;

@RestController
public class BookController {

	@Autowired
	BookServiceImpl bookServiceImpl;

	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return bookServiceImpl.listAllBooks();
	}

	@PostMapping("/books")
	public Book saveBook(@RequestBody Book b) {
		return bookServiceImpl.saveBook(b);
	}

	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable(name = "id") Long id) {
		return bookServiceImpl.bookById(id);
	}

	@PutMapping("/books/{id}")
	public Book updateBook(@PathVariable(name = "id") Long id, @RequestBody Book b) {
		Book selectedBook;
		Book updatedBook;

		selectedBook = bookServiceImpl.bookById(id);

		selectedBook.setTitle(b.getTitle());
		selectedBook.setIsbn(b.getIsbn());
		selectedBook.setSynopsis(b.getSynopsis());
		selectedBook.setAuthor(b.getAuthor());
		selectedBook.setEditorial(b.getEditorial());
		selectedBook.setUsuario(b.getUsuario());

		updatedBook = bookServiceImpl.saveBook(selectedBook);

		return updatedBook;
	}

	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable(name = "id") Long id) {
		bookServiceImpl.deleteBook(id);
	}
	
	@GetMapping("/books/title/{title}")
	public List<Book> getBooksByTitle(@PathVariable(name = "title") String title) {
		return bookServiceImpl.getBooksByTitle(title);
	}
	
	@GetMapping("/books/editorial/{editorial}")
	public List<Book> findBooksByEditorial(@PathVariable(name = "editorial") String editorial) {
		return bookServiceImpl.findBooksByEditorial(editorial);
	}
	

	@GetMapping("/books/author/{author}")
	public List<Book> findBooksByAuthor(@PathVariable(name = "author") String author) {
		return bookServiceImpl.findBooksByAuthor(author);
	}
	
	@GetMapping("/books/user")
	public List<Book> findBooksByUsuario(@RequestBody Usuario usuario) {
		return bookServiceImpl.findBooksByUsuario(usuario);
	}
	
}