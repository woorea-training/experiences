package es.experiences.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Roberto_LoginServlet
 */
@WebServlet("/Login_Roberto")
public class Roberto_LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Roberto_LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			String username=request.getParameter("username");
		
			String password=request.getParameter("password");
			try
	        {			
	            if(username.length()>4 && password.length()>6)
	            {
	            	response.getWriter().println("OK");
	            }
	            else
	            	response.getWriter().println("Username or password could not been shorter than four and six characters.");
	                
	        } catch (Exception e)
	        {
	            System.out.println(e.getMessage());
	        }
		}catch(Exception e)
		{
			response.getWriter().println("GTFO!");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.getWriter().println("Only POST methods accepted!");
		try {
			Thread.sleep(20000);
			resp.sendRedirect("HolaServlet");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	
	

}
