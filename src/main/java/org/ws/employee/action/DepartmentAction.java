package org.ws.employee.action;

import org.ws.employee.domain.Department;
import org.ws.employee.domain.PageBean;
import org.ws.employee.service.DepartmentService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 部门管理的Action的类
 * @author jssjh
 *
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//模型驱动使用的对象
	private Department department = new Department();
	@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		return department;
	}
	
	private Integer currPage = 1;
	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	//注入部门管理service
	private DepartmentService departmentService;

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	//提供一个查询的方法:
	public String findAll() {
		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		//将pageBean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}

	//跳转到添加部门的页面方法:
	public String saveUI(){
		return "saveUI";
	}
	
	//添加部门的执行方法
	public String save() {
		departmentService.save(department);
		return "saveSuccess";
	}
	//编辑部门的执行方法
	public String edit(){
		department = departmentService.findById(department.getDid());
		return "editSuccess";
	}
	
	//修改部门的执行方法
	public String update() {
		departmentService.update(department);
		return "updateSuccess";
	}
	
	//删除部门的执行方法
	public String delete() {
		department = departmentService.findById(department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";
	}
}
