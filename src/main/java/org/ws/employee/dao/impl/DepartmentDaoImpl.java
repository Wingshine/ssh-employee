package org.ws.employee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.ws.employee.dao.DepartmentDao;
import org.ws.employee.domain.Department;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	@Override
	public int findConnt() {
		String hql = "select count(*) from Department";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list.size() > 0){
			return list.get(0).intValue();
		}
		return 0;
	}
	
	/*
	 * 分页查询部门
	 */
	@Override
	public List<Department> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		List<Department> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@Override
	public void save(Department department) {

		this.getHibernateTemplate().save(department);
	}

	//DAO根据部门ID查询部门的方法
	@Override
	public Department findById(Integer did) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Department.class, did);
	}

	//DAO中更新部门的方法
	@Override
	public void update(Department department) {
		this.getHibernateTemplate().update(department);
	}

	//DAO中删除部门的方法
	@Override
	public void delete(Department department) {
		this.getHibernateTemplate().delete(department);
	}

	//查询所有部门的方法
	@Override
	public List<Department> findAll() {
		return this.getHibernateTemplate().find("from Department");
	}
	
}
