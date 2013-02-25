package es.experiences.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AnaLoginServlet
 */
@WebServlet("/AnaLoginServlet")
public class AnaLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnaLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String miuser = request.getParameter("username");
		String mipass = request.getParameter("password");
		
		response.getWriter().println ("Voy a ejecutar mi Servlet");
		if (miuser.length() > 4 && mipass.length() > 6)
		
			response.getWriter().println ("OK, puede continuar");
		else
		
			response.getWriter().println ("ERROR, el usuario debe tener al menos 4 caracteres y la password 6");
		
	
		
	}

}
