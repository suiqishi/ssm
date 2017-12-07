<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".delete").click(function(){
			var href = $(this).attr("href");
			$("form").attr("action",href).submit();
			return false;
		});
	})
</script>

</head>
<body>

	<form action="search" method="post">
		name:<input type="text" name="name"/>&nbsp;&nbsp;
		minage: <input type="text" name="minage"/>&nbsp;&nbsp;
		maxage:<input type="text" name="maxage"/>
		<input type="submit" value="search"/>
	</form>

<br><br>
	<form action="" method="post">
		<input type="hidden" name="_method" value="DELETE"/>
	</form>
	

	
	<c:if test="${empty requestScope.peoples}">
		没有数据
	</c:if>
	<c:if test="${!empty requestScope.peoples}">
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>age</th>
				<th>sex</th>
				<th>address</th>
				<th>phone</th>
				<th>birthday</th>
				<th>Edit</th>
				<th>Delete</th>
				
			</tr>
			<c:forEach items="${requestScope.peoples}" var="p">
				<tr>
					<td>${p.id}</td>
					<td>${p.name}</td>
					<td>${p.age}</td>
					<td>${p.sex == 1?'man':'women'}</td>
					<td>${p.address}</td>
					<td>${p.phone}</td>
					<td>
					<fmt:formatDate value="${p.birthday}" pattern="yyyy-MM-dd" />
					</td>
					<td><a href="people/${p.id}">Edit</td>
					<td><a class="delete" href="people/${p.id}">Delete</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
		<br><br><br><br>
		<a href="people">ADDPeople</a>
	<br><br>
</body>
</html>