package com.cg.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.entity.Product;

public class ProductDao implements ProductDaoI {
	private EntityManagerFactory factory;

	public ProductDao() {
		factory = Persistence.createEntityManagerFactory("MyJPA");
	}

	public int save(Product p) {
		EntityManager mgr = null;
		try {

			mgr = factory.createEntityManager();
			EntityTransaction txn = mgr.getTransaction();
			txn.begin();
			mgr.persist(p);
			txn.commit();
			return p.getCode();
		} finally {
			mgr.close();
		}
	}

	public Product fetch(int code) {
		EntityManager mgr = null;
		try {
			mgr = factory.createEntityManager();
			return (Product) mgr.find(Product.class, code);
		} finally {
			mgr.close();
		}
	}

	public void delete(int code) {
		EntityManager mgr = null;
		try {
			mgr = factory.createEntityManager();
			Product p = (Product) mgr.find(Product.class, code);
			EntityTransaction txn = mgr.getTransaction();
			txn.begin();
			mgr.remove(p);
			txn.commit();
		} finally {
			mgr.close();
		}
	}

	public List<Product> fetchAll() {
		EntityManager mgr = null;
		try {
			mgr = factory.createEntityManager();
			Query query = mgr.createQuery("from Product");
			return query.getResultList();
		} finally {
			mgr.close();
		}
	}

}
