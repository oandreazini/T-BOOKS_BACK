package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

	// Attributes

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 50, unique = true)
	private String name;

	// Constructors

	/**
	 * Default constructor
	 */
	public Role() {
	}

	/**
	 * Constructor by name
	 * 
	 * @param name
	 */
	public Role(String name) {
		this.name = name;
	}

	/**
	 * Constructor by id
	 * 
	 * @param id
	 */
	public Role(Integer id) {
		this.id = id;
	}

	// Getters and setters

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}