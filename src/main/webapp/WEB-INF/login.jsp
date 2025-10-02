<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>Iniciar Sesión</h2>
    <form action="LoginServlet" method="post">
        Nombre: <input type="text" name="nombre"><br>
        Contraseña: <input type="password" name="password"><br>
        <input type="submit" value="Entrar">
    </form>

    <% 
        String error = (String) request.getAttribute("error");
        if (error != null) {
            out.print("<p style='color:red;'>" + error + "</p>");
        }
    %>

</body>
</html>