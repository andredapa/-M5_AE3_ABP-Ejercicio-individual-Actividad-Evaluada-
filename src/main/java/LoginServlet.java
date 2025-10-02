

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
	        String password = request.getParameter("password");

	        // Simulación de credenciales (en un caso real irían en BD)
	        String usuarioValido = "andrea";
	        String passwordValida = "123456";

	        if (nombre.equals(usuarioValido) && password.equals(passwordValida)) {
	            // Guardar en sesión
	            HttpSession sesion = request.getSession();
	            sesion.setAttribute("usuario", nombre);

	            // Crear cookie para recordar al usuario
	            Cookie cookie = new Cookie("usuarioRecordado", nombre);
	            cookie.setMaxAge(7 * 24 * 60 * 60); // 7 días
	            response.addCookie(cookie);

	            request.setAttribute("nombreUsuario", nombre);
	            request.getRequestDispatcher("bienvenida.jsp").forward(request, response);
	        } else {
	            request.setAttribute("error", "Usuario o contraseña incorrectos");
	            request.getRequestDispatcher("login.jsp").forward(request, response);
	        }
	}

}
