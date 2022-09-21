package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Usuario;

public interface IUserDAO extends JpaRepository<Usuario, Long>{

	public Usuario findByUsername(String username);
	
	public Usuario findByEmail(String email);

}
