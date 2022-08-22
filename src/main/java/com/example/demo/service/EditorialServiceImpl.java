package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IEditorialDAO;
import com.example.demo.dto.Editorial;

@Service
public class EditorialServiceImpl implements IEditorialService{

	@Autowired
	IEditorialDAO iEditorialDAO;

	@Override
	public List<Editorial> listAllEditorial() {
		return iEditorialDAO.findAll();
	}

	@Override
	public Editorial saveEditorial(Editorial pr) {
		return iEditorialDAO.save(pr);
	}

	@Override
	public Editorial editorialById(Long id) {
		return iEditorialDAO.findById(id).get();
	}

	@Override
	public Editorial updateEditorial(Editorial pr) {
		return iEditorialDAO.save(pr);
	}

	@Override
	public void deleteEditorial(Long id) {
		iEditorialDAO.deleteById(id);
	}
	
}
