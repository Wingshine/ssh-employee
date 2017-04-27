package org.ws.employee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.ws.employee.dao.EmployeeDao;
import org.ws.employee.domain.Employee;

public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

	@Override
	public Employee findByUsernameAndPassword(Employee employee) {
		String hql = "from Employee where username = ? and password = ?";
		List<Employee> list = this.getHibernateTemplate().find(hql, employee.getUsername(), employee.getPassword());
		if(list.size() > 0){
			return list.get(0); 
		}
		return null;
	}

	@Override
	public int findCount() {
		String hql ="select count(*) from Employee";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list.size() > 0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Employee> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	//DAO中保存员工的方法
	@Override
	public void save(Employee employee) {
		this.getHibernateTemplate().save(employee);
	}

	//DAO中根据员工ID查询员工的方法
	@Override
	public Employee findById(Integer eid) {
		return this.getHibernateTemplate().get(Employee.class, eid);
	}

	//DAO中根据员工ID修改员工的方法
	@Override
	public void update(Employee employee) {
		this.getHibernateTemplate().update(employee);
	}

	//DAO中根据员工ID删除员工的方法
	@Override
	public void delete(Employee employee) {
		this.getHibernateTemplate().delete(employee);
	}

}
