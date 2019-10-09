package com.cg.dao;

import java.util.List;

import com.cg.entity.Trainer;
import com.cg.exception.TrainerNotFoundException;

public interface TrainerDao {
	
	
	Trainer add(Trainer trainer) ;
	
	List<Trainer> fetchall();
	
	boolean delete(int id) throws TrainerNotFoundException;
	
	Trainer find(int id) throws TrainerNotFoundException;
	
	List<Trainer> findByName(String name) throws TrainerNotFoundException;

}
