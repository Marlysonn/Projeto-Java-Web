<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body>
	<!-- <div align="center">
		<c:if test="${client.name != null}">
			<p>Wellcome, Sr. <strong>${client.name}</strong>  </p>
		</c:if>
	</div>-->
	
	<div align="center">
		<c:if test="${clients != null}">
		<c:forEach items="${clients}" var="client">
			<p>ID: <strong>${client.id}</strong>  </p>
			<p>Nome: <strong>${client.name}</strong>  </p>
			<p>E-mail: <strong>${client.email}</strong>  </p>
			<p>Phone: <strong>${client.phone}</strong>  </p>
			<form action="listServlet" method="POST">
				<input type="hidden" name="idClient" value="${client.id}"/>
				<input type="submit" value="Deletar" id="btn-Delete" />
			</form>
			</c:forEach>
		</c:if>
	</div>
</body>
</html>