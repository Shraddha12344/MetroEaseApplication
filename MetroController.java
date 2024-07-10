package com.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.MetroNotFoundException;
import com.model.Metro;
import com.service.MetroService;

@RequestMapping("/m")
@RestController
public class MetroController {
	
	
	 
	@Autowired
	MetroService metroService;
	
/*
-------------------------------------------------------------------------------------------------------------------------	
-------------------------------------------------------------------------------------------------------------------------	
*/
	
	@PostMapping("/add")
	public ResponseEntity<Metro> addMetro(@RequestBody Metro metro) {
		
		Metro m = metroService.saveMetro(metro);
		return ResponseEntity.status(HttpStatus.CREATED).header("Metro", "Metro added").body(m);
	}
	
/*
-------------------------------------------------------------------------------------------------------------------------	
-------------------------------------------------------------------------------------------------------------------------	
*/	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Metro> getOneMetro(@PathVariable ("id") long id) throws MetroNotFoundException{
			
		Metro metro = metroService.getOneMetro(id);
		
		return ResponseEntity.status(HttpStatus.OK).header("metro", "metro found").body(metro);
		
	}
	
/*
-------------------------------------------------------------------------------------------------------------------------	
-------------------------------------------------------------------------------------------------------------------------	
*/
	
	@GetMapping("/getAll")
	public List<Metro> getAllMetro(){
		
		return metroService.getAllMetro();
		
	}
	
/*
-------------------------------------------------------------------------------------------------------------------------	
-------------------------------------------------------------------------------------------------------------------------	
*/
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Metro> updateMetro(@RequestBody Metro metro)
	{
		Metro m = metroService.updateMetro(metro);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("Metro", "Metro updated").body(m);
	}
	
	
/*
-------------------------------------------------------------------------------------------------------------------------	
-------------------------------------------------------------------------------------------------------------------------	
*/
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Object>> deleteMetro(@PathVariable ("id") long id) throws MetroNotFoundException
	{
		Map<String, Object> response = metroService.deleteMetro(id);
		
		return ResponseEntity.ok(response);
	}

    
	
}
