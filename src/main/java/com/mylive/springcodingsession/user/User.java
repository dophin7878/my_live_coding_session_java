package com.mylive.springcodingsession.user;

import com.mylive.springcodingsession.group.Group;
import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private Integer id;

	@Size(min=2, message="Name should have at least 2 characters")
	private String name;

	@Past
	private LocalDate birthDate;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Group group;

	protected User() {
	}

	public User(String name, LocalDate birthDate) {
		super();
		this.name = name;
		this.birthDate = birthDate;
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
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "," +
				"groupId=" + getGroup().getId() + ", groupName=" + getGroup().getName() + "]";
	}

}
