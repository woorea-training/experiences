<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Hola</title>
	</head>
		<body>
			<%
				java.util.Date d = new java.util.Date();
				out.println(d);
			%>
		
			<form action="/experiences-jee/ana-login" method="POST">
				usuario <input type="text" name="username" value="<%= request.getParameter("username") %>" /><br />
				constraseña <input type="password" name="password" value="" /> <br />
				<input type="submit" value="Login" />
			</form>
			
			<%
			for(int i = 0; i < 10; i++) {
			%>
			<h2>Luis es el mejor</h2>
			<%
			}
			%>
		</body>
</html>