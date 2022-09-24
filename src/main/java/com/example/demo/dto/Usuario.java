package com.example.demo.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;

	// Attributes

	public enum Rol {
		ADMIN, USER;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String email;

	private String phone;

	private String city;

	private String username;

	private String password;

	@Enumerated(EnumType.STRING)
	private Rol role = Rol.USER;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "users_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	@OneToMany(mappedBy = "id")
	private List<Loan> loans;

	@OneToMany(mappedBy = "id")
	private List<Book> books;

	// Constructors

	/**
	 * Default constructor
	 */
	public Usuario() {

	}

	/**
	 * Constructor with fields
	 * 
	 * @param id
	 * @param name
	 * @param email
	 * @param phone
	 * @param city
	 * @param username
	 * @param password
	 * @param loans
	 * @param books
	 */
	public Usuario(Long id, String name, String email, String phone, String city, String username, String password,
			List<Loan> loans, List<Book> books) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.city = city;
		this.loans = loans;
		this.books = books;
		this.username = username;
		this.password = password;
	}

	// Getters and Setters

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
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
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
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}

	/**
	 * 
	 * @return roles set
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * 
	 * @param roles
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/**
	 * 
	 * @param role
	 */
	public void addRole(Role role) {
		this.roles.add(role);
	}

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
