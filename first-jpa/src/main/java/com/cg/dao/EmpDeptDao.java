package com.cg.dao;

import com.cg.entity.Department;
import com.cg.entity.Employee;

public interface EmpDeptDao {
	
	void save(Object e);
	
	Employee fetch(int id);
	
	Department fetchDept(int id);
}
