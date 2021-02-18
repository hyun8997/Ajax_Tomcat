<%@page import="dao.Goott_MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	//id 파라미터 값을 받기 + encode 처리
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	
	//DBMS 연결해서 해당 id 존재여부만 return
	Goott_MemberDAO dao = new Goott_MemberDAO();
	
	boolean flag = dao.isExistById(id);
	
	out.println(flag);
%>