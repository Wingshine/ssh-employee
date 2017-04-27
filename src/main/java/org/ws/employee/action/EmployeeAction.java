package org.ws.employee.action;

import java.util.List;

import org.ws.employee.domain.Department;
import org.ws.employee.domain.Employee;
import org.ws.employee.domain.PageBean;
import org.ws.employee.service.DepartmentService;
import org.ws.employee.service.EmployeeService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.regexp.internal.recompile;

/**
 * 员工管理的Action类
 * @author jssjh
 *
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//模型驱动使用的对象
	private Employee employee = new Employee();
	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}
	
	private EmployeeService employeeService;
	private DepartmentService departmentService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	/**
	 * 登录执行的方法
	 * @return
	 */
	public String login(){
		System.out.println("login执行了");
		//调用业务层类
		Employee existEmployee = employeeService.login(employee);
		if(existEmployee == null){
			//登录失败
			this.addActionError("用户名或密码错误");
			return INPUT;
		}else{
			//登录成功
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
	}
	
	public String logout(){
		ActionContext.getContext().getSession().remove("existEmployee");
		return INPUT;
	}
	
	//接收当前页数
	private Integer currPage = 1;
	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	/*
	 * 分页查询员工的执行方法
	 */
	public String findAll() {
		PageBean<Employee> pageBean = employeeService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";   
	}
	
	/*
	 * 跳转到添加员工页面执行的方法
	 */
	public String saveUI(){
		//查询所有部门
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	
	/*
	 * 保存员工的方法 
	 */
	public String save() {
		employeeService.save(employee);
		return "saveSuccess";
	}
	
	public String edit() {
		//根据员工ID查询员工
		employee = employeeService.findById(employee.getEid());
		//查询所有部门
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "editSuccess";
	}
	
	/*
	 * 修改员工的方法
	 */
	public String update(){
		employeeService.update(employee);
		return "updateSuccess";
	}
	
	/*
	 * 删除员工的方法
	 */
	public String delete() {
		employee = employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";
	}
}
