package com.flowercolor.shop.resources;

import com.flowercolor.shop.entities.Supplier;
import com.flowercolor.shop.services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.flowercolor.shop.entities.Enterprise;

import java.util.List;

@RestController
@RequestMapping (value = "/enterprises")
public class EnterpriseResource {

	@Autowired
	private EnterpriseService service;

	@GetMapping
	public ResponseEntity<List<Enterprise>> findAll(){
		return ResponseEntity.ok(this.service.list());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Enterprise> findById(@RequestParam Long id){
		return ResponseEntity.ok(this.service.findByID(id));
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<Enterprise> update(@RequestParam Long id, @RequestBody Enterprise enterpriseDto){
		return ResponseEntity.ok(this.service.update(id, enterpriseDto));

	}

	@PostMapping
	public ResponseEntity<Void> create(@RequestBody Enterprise enterpriseDto){
		this.service.create(enterpriseDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
