<%@page import="es.experiences.model.Box"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Caja XXX</title>
</head>
<body>
<%

	Box box = (Box) request.getAttribute("box");

%>
<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Titulo</th>
				<th>Estado</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%= box.getId() %></td>
				<td><%= box.getName() %></td>
				<td><%= box.getTitle() %></td>
				<td><%= box.isActivated() %></td>
			</tr>
		</tbody>
	</table>
</body>
</html>