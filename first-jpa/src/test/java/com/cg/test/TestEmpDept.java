package com.cg.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.dao.EmpDeptDao;
import com.cg.dao.EmpDeptDaoImpl;
import com.cg.entity.Department;
import com.cg.entity.Employee;

public class TestEmpDept {
	private EmpDeptDao dao;
	
	@Before
	public void init()
	{
		dao = new EmpDeptDaoImpl();
	}
	@Test
	public void testCasCade() {
		Department d = new Department();
		d.setDeptNo(30);
		d.setDept("Sales");
		
		Employee e2 = new Employee();
		e2.setEmpName("Arvish");
		e2.setSalary(5100);
		e2.setDept(d);
		
		Employee e1 = new Employee();
		e1.setEmpName("Jyoti");
		e1.setSalary(5200);
		e1.setDept(d);
		
		d.getEmps().add(e1);
		d.getEmps().add(e2);
		
		dao.save(d);
		
	}
	
//	@Test
//	public void testSaveDept() {
//		Department d = new Department();
//		d.setDeptNo(10);
//		d.setDept("Finance");
//		dao.save(d);
//	
//	}
//	@Test
//	public void testSaveEmp() {
//		Employee e = new Employee();
//		e.setEmpName("Polo");
//		e.setSalary(5000);
//		
//		Department d = dao.fetchDept(10);
//		e.setDept(d);
//		
//		dao.save(e);
//		
//	}
//	
//	@Test
//	public void testFetch() {
//		Department d = dao.fetchDept(10);
//		System.out.println(d.getDept());
//		System.out.println(d.getEmps());
//	}
@After
public void vanish() {
	dao = null;
}
}
