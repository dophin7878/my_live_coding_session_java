package com.mylive.springcodingsession.group;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="USERGROUP")
public class Group {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private Integer id;
	
	@Size(min=2, message="Name should have at least 2 characters")
	private String name;

	protected Group() {
	}
	
	public Group(String name) {
		super();
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + "]";
	}
	
}
