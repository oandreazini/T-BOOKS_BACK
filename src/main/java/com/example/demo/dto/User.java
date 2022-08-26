package com.example.demo.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	private String email;
	
	private String phone;

	@OneToMany
	@JoinColumn(name = "id")
	private List<Loan> loans;
	
	@OneToMany
	@JoinColumn(name = "id")
	private List<Book> books;

	//Constructors
	
	/**
	 * Default constructor
	 */
	public User() {

	}
	
	/**
	 * Constructor with fields
	 * 
	 * @param id
	 * @param name
	 * @param email
	 * @param phone
	 * @param loans
	 * @param books
	 */
	public User(Long id, String name, String email, String phone, List<Loan> loans, List<Book> books) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.loans = loans;
		this.books = books;
	}

	//Getters and Setters
	/**
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 
	 * @return loan
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Loan")
	public List<Loan> getLoans() {
		return loans;
	}

	/**
	 * 
	 * @param loans
	 */
	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

	/**
	 * 
	 * @return book
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Book")
	public List<Book> getBooks() {
		return books;
	}

	/**
	 * 
	 * @param books
	 */
	public void setBooks(List<Book> books) {
		this.books = books;
	}

	/**
	 * To String of the class
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", loans=" + loans
				+ ", books=" + books + "]";
	}

}
