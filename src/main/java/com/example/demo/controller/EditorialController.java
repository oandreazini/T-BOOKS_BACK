package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Editorial;
import com.example.demo.service.EditorialServiceImpl;

@RestController
@RequestMapping("/api")
public class EditorialController {

	@Autowired
	EditorialServiceImpl providerServiceImpl;
	
	@GetMapping("/providers")
	public List<Editorial> getAllProviders() {
		return providerServiceImpl.listAllProviders();
	}
	
	@PostMapping("/providers")
	public Editorial saveProvider(@RequestBody Editorial pr) {
		return providerServiceImpl.saveProvider(pr);
	}
	
	@GetMapping("/providers/{id}")
	public Editorial getProviderById(@PathVariable(name="id") Long id) {
		return providerServiceImpl.providerById(id);
	}
	
	@PutMapping("/providers/{id}")
	public Editorial updateProvider(@PathVariable(name="id") Long id, @RequestBody Editorial pr) {
		Editorial selectedProvider;
		Editorial updatedProvider;
		
		selectedProvider = providerServiceImpl.providerById(id);
		
		selectedProvider.setName(pr.getName());
		selectedProvider.setSupplies(pr.getSupplies());
		
		updatedProvider = providerServiceImpl.saveProvider(selectedProvider);
		
		return updatedProvider;
	}
	
	@DeleteMapping("/providers/{id}")
	public void deleteProvider(@PathVariable(name="id") Long id) {
		providerServiceImpl.deleteProvider(id);
	}
}
