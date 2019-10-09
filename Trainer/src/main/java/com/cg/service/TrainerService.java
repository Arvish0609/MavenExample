package com.cg.service;

import java.util.List;

import com.cg.entity.Trainer;
import com.cg.exception.TrainerNotFoundException;

public interface TrainerService {

	Trainer addtrainer(Trainer trainer);
	
	List<Trainer> findall();
	
	boolean deleteTrainer(int id) throws TrainerNotFoundException;
	
	Trainer findTrainer(int id) throws TrainerNotFoundException;
	
	List<Trainer> fetchByName(String name) throws TrainerNotFoundException;

}
