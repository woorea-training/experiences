package es.experiences.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import es.experiences.model.Box;

@Singleton
@Path("/v1/boxes")
public class BoxesService {
	
	//@PersistenceContext(unitName="experiences-jee")
	//private EntityManager em;
	
	public static final List<Box> BOXES = new ArrayList<Box>() {{
		Box b = new Box("1","name.1","title.1",true);
		add(b);
		
	}};

	@GET
	public List<Box> list() {
		return BOXES;
		//return em.createQuery("SELECT b FROM Box b").getResultList();
	}
	
	@POST
	public Box create(Box box) {
		
		//em.persist(box);
		//em.flush();
		return box;
	}
	
	@GET
	@Path("{id}")
	public Box show(@PathParam("id") String id) {
		return BOXES.get(0);
		//return em.find(Box.class, id);
	}
	
	@PUT
	@Path("{id}")
	public Box update(@PathParam("id") String id, Box box) {
		//em.merge(box);
		//em.flush();
		return box;
	}
	
	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") String id) {
		//em.remove(em.find(Box.class, id));
		//em.flush();
	}

}
