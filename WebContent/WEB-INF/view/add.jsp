<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/save" method="post" modelAttribute="people">
		<c:if test="${people.id != null}">
				<form:hidden path="id"/>
			    <input type="hidden" name="_method" value="PUT"/>
		</c:if>
		name:<form:input path="name"/><br><br>
		age:<form:input path="age"/><br><br>
		<% 
			Map<String,String> sexs = new HashMap<String,String>();
			sexs.put("1", "Male");
			sexs.put("2","Female");
			request.setAttribute("sexs", sexs);

		%>
		sex:<form:radiobuttons path="sex" items="${sexs}"/><br><br>
		address:<form:input path="address"/><br><br>
		phone:<form:input path="phone"/><br><br>
		birthday:<form:input path="birthday"/><br><br>
		<input type="submit" value="submit"/>
	</form:form>
</body>
</html>