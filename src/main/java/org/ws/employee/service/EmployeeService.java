package org.ws.employee.service;

import org.ws.employee.domain.Employee;
import org.ws.employee.domain.PageBean;

/**
 * 员工管理的业务层的接口
 * @author jssjh
 *
 */
public interface EmployeeService {
	public Employee	login(Employee employee);

	public PageBean<Employee> findByPage(Integer currPage);

	public void save(Employee employee);

	public Employee findById(Integer eid);

	public void update(Employee employee);

	public void delete(Employee employee);
}
