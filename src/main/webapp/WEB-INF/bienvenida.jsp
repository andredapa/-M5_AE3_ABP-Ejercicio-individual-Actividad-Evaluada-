<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenida</title>
</head>
<body>
    <h2>
        <% 
            String nombre = (String) request.getAttribute("nombreUsuario");
            if (nombre == null) {
                nombre = (String) session.getAttribute("usuario");
            }

            if (nombre == null) {
                // Revisar cookies
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie c : cookies) {
                        if (c.getName().equals("usuarioRecordado")) {
                            nombre = c.getValue();
                        }
                    }
                }
            }

            if (nombre != null) {
                out.print("¡Bienvenido/a, " + nombre + "!");
            } else {
                out.print("Bienvenido/a visitante. <a href='login.jsp'>Inicia sesión</a>");
            }
        %>
    </h2>
</body>
</html>