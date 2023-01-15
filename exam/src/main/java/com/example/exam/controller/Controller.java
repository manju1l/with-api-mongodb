package com.example.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.exam.model.Model;
import com.example.exam.repo.Repo;



@RestController
public class Controller {
	
	@Autowired
	Repo repo;
	
@PostMapping("/create")
	public Model create (@RequestBody Model model) {
		return this.repo.save(model);
		
	}
	@GetMapping("/getall")
	public List<Model>add(){                                                                                               
		return this.repo.findAll();
	}
	
	
	@GetMapping("/{id}")
	public Model find (@PathVariable(value="id") int id) {
		return this.repo.findById(id).orElseThrow();
		
	}
	
	
	@DeleteMapping("/{id}")
	public String del (@PathVariable int id) {
		this.repo.deleteById(id);
		return "deleted "+id;
	}
	
	
	@PostMapping("/{id}")
	public Model update(@RequestBody Model model,@PathVariable("id") int id) {
		Model ex=this.repo.findById(id).orElseThrow();
		ex.setName(model.getName());
		return this.repo.save(ex);
		
	}

}
