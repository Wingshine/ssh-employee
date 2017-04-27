package org.ws.employee.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptoe extends MethodFilterInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation paramActionInvocation) throws Exception {
		Object loginUserName = ActionContext.getContext().getSession().get("existEmployee");  
        if(null == loginUserName){  
            return "input";  // 这里返回用户登录页面视图  
        }  
        return paramActionInvocation.invoke(); 
	}

}
