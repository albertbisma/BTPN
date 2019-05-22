package org.spring.controller;

import org.spring.model.Nasabah;
import org.spring.service.NasabahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exception.Errorexception;

@RestController
@RequestMapping("/nasabah")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NasabahController {
	
	@Autowired
	private NasabahService nasabahService;
	
	@GetMapping("")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(nasabahService.getAll());
	}
	
	@PostMapping("")
	public ResponseEntity<?> insert(@RequestBody Nasabah nasabah) throws Errorexception{
		try {
			nasabahService.insert(nasabah);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("Data Nasabah berhasil di buat ");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) throws Errorexception{		
		try{		
			nasabahService.delete(id);		
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body("Data Nasabah berhasil dihapus");
	}
	
	@PutMapping("")
	public ResponseEntity<?> update(@RequestBody Nasabah nasabah) throws Errorexception{
		try {
			nasabahService.update(nasabah);							
			}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body("Data Nasabah berhasil diupdate");
					
	}
}
