<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
  Object username = session.getAttribute("existEmployee");  
  if(null == username){  
        
      response.sendRedirect("index.jsp");  
  }  
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工管理系统</title>
</head>
<frameset rows="80,*" id="main">
   <frame name="top" src="<%=request.getContextPath()%>/frame/top.jsp">
   <frameset cols="150,*" id="main">

      <frame src="<%=request.getContextPath()%>/frame/left.jsp"> 
     <frame name="right" src="<%=request.getContextPath()%>/frame/right.jsp">
   </frameset>
</frameset>
</html>