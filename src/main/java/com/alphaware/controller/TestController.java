package com.alphaware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alphaware.entity.Users;
import com.alphaware.repository.UserRepository;

@RestController
public class TestController {

	@Autowired
	private UserRepository repo;
	
	
	@GetMapping("/hi")
	public String  hello() {
		return "hello";
	}
	
	@GetMapping("/all")
	public List<Users> get() {
		return repo.findAll();
	}
	
	@GetMapping("/search")
    public List<Users> searchUsers(@RequestParam(value = "filter") String filter) {
        return repo.findByFilter(filter);
    }
}
