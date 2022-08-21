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

	
}
