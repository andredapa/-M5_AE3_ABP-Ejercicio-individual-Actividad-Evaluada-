package com.skillnest.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class RegistroServlet
 */
@WebServlet("/registroservlet")
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 String nombre = request.getParameter("nombre");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");

	        // Validaciones
	        if (nombre == null || nombre.isEmpty() || 
	            email == null || email.isEmpty() || 
	            password == null || password.isEmpty()) {
	            
	            request.setAttribute("error", "Todos los campos son obligatorios.");
	            request.getRequestDispatcher("registro.jsp").forward(request, response);
	            return;
	        }

	        // Guardar el nombre en la sesión
	        HttpSession sesion = request.getSession();
	        sesion.setAttribute("usuario", nombre);

	        // Pasar el nombre al JSP
	        request.setAttribute("nombreUsuario", nombre);

	        // Redirigir a bienvenida
	        request.getRequestDispatcher("bienvenida.jsp").forward(request, response);
	}

}
