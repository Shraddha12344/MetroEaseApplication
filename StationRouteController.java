package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exception.StationRouteNotFoundException;
import com.model.StationRoute;
import com.service.StationRouteService;

@RequestMapping("/s")
@RestController
public class StationRouteController {

	@Autowired
	StationRouteService stationRouteService;

	
/*
-------------------------------------------------------------------------------------------------------------------------	
-------------------------------------------------------------------------------------------------------------------------	
*/
		
	@PostMapping("/add")
	public StationRoute addStationRoute(@RequestBody StationRoute stationRoute) {
		
		return stationRouteService.saveStationRoute(stationRoute);
	}

	
/*
-------------------------------------------------------------------------------------------------------------------------	
-------------------------------------------------------------------------------------------------------------------------	
*/
	
	
	@GetMapping("/get/{id}")
	public StationRoute getStationRoute(@PathVariable long id) {
		return stationRouteService.getStationRoute(id);
	}

	
/*
-------------------------------------------------------------------------------------------------------------------------	
-------------------------------------------------------------------------------------------------------------------------	
*/
	
	
	@GetMapping("/getAll")
	public List<StationRoute> getAllStationRoute(){
		return stationRouteService.getAllStationRoute();
	}
	
	
/*
-------------------------------------------------------------------------------------------------------------------------	
-------------------------------------------------------------------------------------------------------------------------	
*/
	
	
	@PutMapping("/update")
	public ResponseEntity<StationRoute> updatedStationRoute(@RequestBody StationRoute stationRoute){
		
		StationRoute station = stationRouteService.updateStationRoute(stationRoute);
		
		return ResponseEntity.ok(station);
	}

	
/*
-------------------------------------------------------------------------------------------------------------------------	
-------------------------------------------------------------------------------------------------------------------------	
*/
	

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Object>> deleteStationRoute(@PathVariable long id) throws StationRouteNotFoundException{
		
		Map<String, Object> response = stationRouteService.deleteStationRoute(id);
		
		return ResponseEntity.ok(response);	
	}


}
