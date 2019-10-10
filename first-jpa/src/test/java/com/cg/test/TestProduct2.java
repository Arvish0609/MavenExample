package com.cg.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import com.cg.entity.Product;

public class TestProduct2 {
	
	@Test
	public void testDetached() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyJPA");
		EntityManager mgr = factory.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		txn.begin();
		Product p = (Product) mgr.find(Product.class, 1);
		p.setName("arvish");
		txn.commit();
		mgr.close();

		mgr = factory.createEntityManager();
		txn = mgr.getTransaction();
		txn.begin();
		p = (Product) mgr.find(Product.class, 2);
		p.setStock(90);
		p.setName("huwavei");
		mgr.merge(p); // to update existing entity in table
		txn.commit();
		mgr.close();
	}

	@Test
	public void testMerge() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyJPA");
		EntityManager mgr = factory.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		txn.begin();
		Product p = new Product();
		p.setCode(1); // if the code doesnt matches, new record will be added
		p.setName("RealMe"); // and the code will be auto generated
		p.setPrice(5000); // but if the code matches, the existing record will be
		p.setStock(20); // updated.
		mgr.merge(p);
		txn.commit();
		mgr.close();
	}

	
}
