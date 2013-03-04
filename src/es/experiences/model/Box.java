package es.experiences.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Box {

	@Id
	private String id;
	
	private String name;
	
	private String title;
	
	private boolean activated;
	
	public Box(String id, String name, String title, boolean activated) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.activated = activated;
	}

	public Box() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

}
