package com.cg.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.dao.ProductDao;
import com.cg.dao.ProductDaoI;
import com.cg.entity.Product;

public class TestProduct {
	private EntityManager mgr;
	private ProductDaoI pdi;
	@Before
	public void setup() {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("MyJPA");
		mgr = factory.createEntityManager();
	    pdi = new ProductDao();
	}
	
	@After
	public void tearDown() {
		mgr.close();
	}
	@Test
	public void testSaveProduct() {
		EntityTransaction txn = mgr.getTransaction();
		txn.begin();
		Product p = new Product();
		p.setName("iPhone");
		p.setPrice(19999.99);
		p.setStock(25);
		mgr.persist(p);
		txn.commit();
	}
	 
	@Test
	public void testDeleteProduct() {
		Product p = new Product();
	    pdi.delete(21);
	    assertEquals(null,p.getName());
	   
		
	}

	@Test
	public void testDetached() {
		EntityTransaction txn = mgr.getTransaction();
		txn.begin();
		Product p = (Product) mgr.find(Product.class, 1);
		txn.commit();
		txn.begin();
		p.setStock(60);
		txn.commit();
	}
	@Test
	public void testFetchProduct() {
		Query que = mgr.createQuery("from Product where price>:pr"); // :pr acts just as ? in old code
		que.setParameter("pr", 5000.0);
		List<Product> products = que.getResultList();
		for (Product p : products) {
			System.out.println(p.getName());
		}

	}
	@Test
	public void testNamedQuery() {
		Query que = mgr.createNamedQuery("stockQuery"); 
		que.setParameter("st", 20);
		List<Product> products = que.getResultList();
		for (Product p : products) {
			System.out.println(p.getName());
		}

	}

}
