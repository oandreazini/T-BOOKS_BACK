package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IUserDAO;
import com.example.demo.dto.User;


@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	IUserDAO iUserDAO;

	@Override
	public List<User> listAllUsers() {
		return iUserDAO.findAll();
	}

	@Override
	public User saveUser(User user) {
		return iUserDAO.save(user);
	}

	@Override
	public User userById(Long id) {
		return iUserDAO.findById(id).get();
	}

	@Override
	public User updateUser(User user) {
		return iUserDAO.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		iUserDAO.deleteById(id);
	}
}
