package com.flowercolor.shop.resources;

import com.flowercolor.shop.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.flowercolor.shop.entities.Supplier;

import java.util.List;

@RestController
@RequestMapping (value = "/suppliers")
public class SupplierResource {

	@Autowired
 	private SupplierService service;

	@GetMapping
	public ResponseEntity<List<Supplier>> findAll(){
		return ResponseEntity.ok(this.service.list());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Supplier> findById(@RequestParam Long id){
		return ResponseEntity.ok(this.service.findById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Supplier> update(@RequestParam Long id, @RequestBody Supplier supplierDto){
		return ResponseEntity.ok(this.service.update(id, supplierDto));

	}

	@PostMapping
	public ResponseEntity<Void> create(@RequestBody Supplier supplierDto){
		this.service.create(supplierDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
