package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.entity.Trainer;
import com.cg.exception.TrainerNotFoundException;
@Repository
public class TrainerDaoImpl implements TrainerDao {
	
	
	@Autowired
	private EntityManager mgr;

	@Override
	public Trainer add(Trainer trainer) {
		mgr.persist(trainer);
		return trainer;
	}

	@Override
	public List<Trainer> fetchall() {
		List<Trainer> t3= mgr.createNamedQuery("findall").getResultList();
		return t3;
	}

	@Override
	public boolean delete(int id) throws TrainerNotFoundException{
		Trainer t = (Trainer) mgr.find(Trainer.class, id);
		mgr.remove(t);
		return true;
	}

	@Override
	public Trainer find(int id) throws TrainerNotFoundException{
		Trainer t1= (Trainer) mgr.find(Trainer.class, id);
		return t1;
	}

	@Override
	public List<Trainer> findByName(String name)throws TrainerNotFoundException {
		List<Trainer> t2 = mgr.createNamedQuery("findbyname").setParameter("tname", name).getResultList();
		return t2;
	}

}
