package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.IBookDAO;
import com.example.demo.dto.Book;
import com.example.demo.service.BookServiceImpl;
import com.example.demo.service.UserDetailsServiceImpl;


@RestController
public class BookController {

	@Autowired
	BookServiceImpl bookServiceImpl;
	
	@Autowired
	UserDetailsServiceImpl userServiceImpl;
	
	@Autowired
	IBookDAO ibookDAO;
	
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
	
	@GetMapping("/books/user/{id}")
	public List<Book> findBooksByIdUsuario(@PathVariable(name = "id") Long idUsuario) {
		return bookServiceImpl.findBooksByUsuario(userServiceImpl.userById(idUsuario));
	}
	
	@GetMapping("/books/isbn/{isbn}")
	public List<Book> findBooksByIsbn(@PathVariable(name = "isbn") String isbn) {
		return bookServiceImpl.findBooksByIsbn(isbn);
	}
	
	@GetMapping("/bookspage")
	public Page<Book> getAPageBooks(
			@RequestParam Optional<String> sortBy,
			@RequestParam Optional <Integer> page
			) {
		return ibookDAO.findAll(
				PageRequest.of(
				page.orElse(0),2,
				
				Sort.Direction.ASC, sortBy.orElse( "id"))
	);
	}
	
}
