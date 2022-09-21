package com.example.demo.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IUserDAO;
import com.example.demo.dto.Usuario;


@Service
public class UserDetailsServiceImpl implements UserDetailsService, IUserService {

	private IUserDAO iUserDAO;

	public UserDetailsServiceImpl(IUserDAO iUserDAO) {
		this.iUserDAO = iUserDAO;
	}

	@Override
	public Usuario loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = iUserDAO.findByUsername(username);
		if (user == null) {
			return null;
		}
		return user;
	}

	@Override
	public List<Usuario> listAllUsers() {
		return iUserDAO.findAll();
	}

	@Override
	public Usuario saveUser(Usuario user) {
		return iUserDAO.save(user);
	}

	@Override
	public Usuario userById(Long id) {
		return iUserDAO.findById(id).get();
	}

	@Override
	public Usuario updateUser(Usuario user) {
		return iUserDAO.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		iUserDAO.deleteById(id);
	}
	
	@Override
	public Usuario getUsuarioByUsername(String username) {
		return iUserDAO.findByUsername(username);
	}

	
	public Usuario getUsuarioByEmail(String email) {
		return iUserDAO.findByEmail(email);
	}

	
	public Usuario getUsuarioByPhone(String phone) {
		return iUserDAO.findByPhone(phone);
	}

}
