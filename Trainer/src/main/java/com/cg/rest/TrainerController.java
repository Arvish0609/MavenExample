package com.cg.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Trainer;
import com.cg.exception.TrainerNotFoundException;
import com.cg.service.TrainerService;

@RestController
@RequestMapping("/trainer")
public class TrainerController {
	
	@Autowired
	private TrainerService service;
	
	@PostMapping(value ="/add" , consumes = "application/json", produces = "application/json")
	public Trainer addTrainer(@RequestBody Trainer trainer) {
		return service.addtrainer(trainer);
	}
	
	@GetMapping(produces = "application/json")
	public List<Trainer> fetchAllTrainers(){
		return service.findall();
	}
	
	@DeleteMapping(value ="/delete", produces = "application/json")
	public boolean deleteTrainer(@RequestParam int id) throws TrainerNotFoundException {
		return service.deleteTrainer(id);
	}
	
	@GetMapping(value ="/find" , produces = "application/json")
	public Trainer findTrainer(@RequestParam int id) throws TrainerNotFoundException {
		return service.findTrainer(id);
	}
	
	@GetMapping(value = "/tname" , produces = "application/json")
	public List<Trainer> findByName(@RequestParam String name) throws TrainerNotFoundException{
		return service.fetchByName(name);
	}

}
