<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	String id = request.getParameter("id");
	System.out.println("id: " + id);
	
	MemberDao dao = MemberDao.getInstance();
	boolean b = dao.getId(id);
	
	if(b==true){			// id있음
		out.println("NO");
	}else{					// id 없음
		out.println("YES");
	}
%>
    