package es.experiences.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.experiences.model.Box;
import es.experiences.services.BoxesService;

/**
 * Servlet implementation class BoxesServlet
 */
@WebServlet("/boxes")
public class BoxesServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private BoxesService service;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * GET /boxes 				: listado de todas las cajas
	 * GET /boxes?id=			: crear una nueva caja
	 * GET /boxes?id=<box_id>	: mostrar/editar la caja con identificador <box_id>
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id == null) {
			//list
			request.setAttribute("boxes", service.list());
			request.getRequestDispatcher("/boxes/list.jsp").forward(request, response);
		} else if (id.length() == 0) {
			//crear
			Box box = new Box(null, "","",false);
			request.setAttribute("box", box);
			request.getRequestDispatcher("/boxes/show.jsp").forward(request, response);
		} else {
			//show/edit
			Box box = service.show(id);
			if(box != null) {
				request.setAttribute("box", box);
				request.getRequestDispatcher("/boxes/show.jsp").forward(request, response);
			} else {
				response.sendRedirect("/experiences-jee/boxes");
			}
			
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * POST /boxes					: añadir una nueva caja
	 * POST /boxes?_action=update	: modificar una caja
	 * POST /boxes?_action=delete	: borrar una caja
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("_action");
		if(action == null) {
			if(request.getParameter("name").contains("<script>") || request.getParameter("title").contains("<script>")) {
				response.sendRedirect("http://www.fcbarcelona.es/");
			} else {
				//create
				Box box = new Box(
					UUID.randomUUID().toString(),
					request.getParameter("name"),
					request.getParameter("title"),
					request.getParameter("activated") != null
				);
				service.create(box);
				
				response.sendRedirect("/experiences-jee/boxes?id="+box.getId());
			}
		} else if ("update".equals(action)) {
			//update
			Box box = service.show(request.getParameter("id"));
			box.setName(request.getParameter("name"));
			box.setTitle(request.getParameter("title"));
			box.setActivated(request.getParameter("activated") != null);
			service.update(request.getParameter("id"), box);
			response.sendRedirect("/experiences-jee/boxes?id="+box.getId());
		} else if ("delete".equals(action)) {
			//delete
			service.delete(request.getParameter("id"));
			response.sendRedirect("/experiences-jee/boxes");
		}
	}
	
}
