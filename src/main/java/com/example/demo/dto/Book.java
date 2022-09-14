package com.example.demo.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String isbn;

	private String synopsis;

	@ManyToOne
	@JoinColumn(name = "author")
	private Author author;

	@ManyToOne
	@JoinColumn(name = "editorial")
	private Editorial editorial;

	@ManyToOne
	@JoinColumn(name = "user")
	private User user;

	@OneToMany
	@JoinColumn(name = "id")
	private List<Loan> loans;

	// Constructors

	/**
	 * Default constructor
	 */
	public Book() {

	}

	/**
	 * Constructor with fields
	 * 
	 * @param id
	 * @param title
	 * @param isbn
	 * @param synopsis
	 * @param author
	 * @param editorial
	 * @param user
	 * @param loans
	 */
	public Book(Long id, String title, String isbn, String synopsis, Author author, Editorial editorial, User user,
			List<Loan> loans) {
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.synopsis = synopsis;
		this.author = author;
		this.editorial = editorial;
		this.user = user;
		this.loans = loans;
	}

	
	//Getters and setters
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the synopsis
	 */
	public String getSynopsis() {
		return synopsis;
	}

	/**
	 * @param synopsis the synopsis to set
	 */
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	/**
	 * @return the author
	 */
	public Author getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(Author author) {
		this.author = author;
	}

	/**
	 * @return the editorial
	 */
	public Editorial getEditorial() {
		return editorial;
	}

	/**
	 * @param editorial the editorial to set
	 */
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the loans to get
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Loan")
	public List<Loan> getLoans() {
		return loans;
	}

	/**
	 * @param loans the loans to set
	 */
	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

	/**
	 * To string of the class
	 */
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", isbn=" + isbn + ", synopsis=" + synopsis + ", author="
				+ author + ", editorial=" + editorial + ", user=" + user + ", loans=" + loans + "]";
	}
}
