package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.Author;
import com.example.demo.dto.Book;
import com.example.demo.dto.Editorial;
import com.example.demo.service.BookServiceImpl;

@RestController
@RequestMapping("/api")
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
		selectedBook.setUser(b.getUser());

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
	
	@GetMapping("/books/editorial")
	public List<Book> findBooksByEditorial(@RequestBody Editorial editorial) {
		return bookServiceImpl.findBooksByEditorial(editorial);
	}
	

	@GetMapping("/books/author")
	public List<Book> findBooksByAuthor(@RequestBody Author author) {
		return bookServiceImpl.findBooksByAuthor(author);
	}
	
	public String decoImg(String filePath) throws IOException {
		//TODO
		byte[] fileContent = FileUtils.readFileToByteArray(new File(filePath));
		String encodedString = Base64.getEncoder().encodeToString(fileContent);
		return encodedString;
	}
	
	public void encodImg(String encodedString) throws IOException {
		//TODO
		byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
		FileUtils.writeByteArrayToFile(new File("Foto"), decodedBytes);
	}
}