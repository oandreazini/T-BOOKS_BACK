package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "authors")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="name_surname")
	private String nameSurname;

	@OneToMany(mappedBy="id")
	private List<Book> books;

	// Constructors

	/**
	 * Default constructor
	 */
	public Author() {

	}

	
	/**
	 * Constructor with fields
	 * 
	 * @param id
	 * @param name
	 * @param books
	 */
	public Author(Long id, String nameSurname, List<Book> books) {
		this.id = id;
		this.nameSurname = nameSurname;
		this.books = books;
	}


	// Getters and setters

	/**
	 * 
	 * @return id
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
	 * 
	 * @return nameSurname
	 */
	public String getNameSurname() {
		return nameSurname;
	}

	/**
	 * 
	 * @param nameSurname
	 */
	public void setNameSurname(String nameSurname) {
		this.nameSurname = nameSurname;
	}

	/**
	 * 
	 * @param books
	 */
	public void setBooks(List<Book> books) {
		this.books = books;
	}

	/**
	 * @return the list of Books
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Book")
	public List<Book> getBooks() {
		return books;
	}

	/**
	 * To String of the class
	 */
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + nameSurname + ", books=" + books + "]";
	}
	
	
}