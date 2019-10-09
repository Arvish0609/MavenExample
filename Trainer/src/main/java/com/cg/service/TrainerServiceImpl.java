package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.TrainerDao;
import com.cg.entity.Trainer;
import com.cg.exception.TrainerNotFoundException;

@Service
@Transactional(rollbackFor = TrainerNotFoundException.class)
public class TrainerServiceImpl implements TrainerService {
	Trainer t = new Trainer();
	@Autowired
	private TrainerDao dao;

	@Override
	public Trainer addtrainer(Trainer trainer) {
		return dao.add(trainer);
	}

	@Override
	public List<Trainer> findall() {
		return dao.fetchall();
	}

	@Override
	public boolean deleteTrainer(int id) throws TrainerNotFoundException {
		if(t.getId()==id)
		return dao.delete(id);
		throw new TrainerNotFoundException("error in delete method");

	}

	@Override
	public Trainer findTrainer(int id) throws TrainerNotFoundException {
		if(t.getId()==id)
		return dao.find(id);
		throw new TrainerNotFoundException("error in findtrainer method");
	}

	@Override
	public List<Trainer> fetchByName(String name) throws TrainerNotFoundException {
		if(t.getName()==name)
		return dao.findByName(name);
		throw new TrainerNotFoundException("error in fetch by name method");
	}

}
