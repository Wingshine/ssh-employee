package org.ws.employee.dao;

import java.util.List;

import org.ws.employee.domain.Department;

public interface DepartmentDao {

	int findConnt();

	List<Department> findByPage(int begin, int pageSize);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();
	
}
