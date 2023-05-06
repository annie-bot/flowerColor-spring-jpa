package com.flowercolor.shop.resources;

import com.flowercolor.shop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.flowercolor.shop.entities.User;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		return ResponseEntity.ok(this.service.list());
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@RequestParam Long id){
		return ResponseEntity.ok(this.service.findById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> update(@RequestParam Long id, @RequestBody User userDto){
		return ResponseEntity.ok(this.service.update(id, userDto));
	}

	@PostMapping
	public ResponseEntity<Void> create(@RequestBody User userDto){
		this.service.create(userDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
