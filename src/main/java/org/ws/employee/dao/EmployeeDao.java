package org.ws.employee.dao;

import java.util.List;

import org.ws.employee.domain.Employee;

/**
 * 员工管理DAO的接口
 * @author jssjh
 *
 */
public interface EmployeeDao {
	public Employee findByUsernameAndPassword(Employee employee);

	public int findCount();

	public List<Employee> findByPage(int begin, int pageSize);

	public void save(Employee employee);

	public Employee findById(Integer eid);

	public void update(Employee employee);

	public void delete(Employee employee);
}
