package com.mylive.springcodingsession.group;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mylive.springcodingsession.employee.Employee;

@Entity
@Table(name="group_")
public class Group {
	
	@Id
	@GeneratedValue
	@Column(name="id_group")
	private Integer idGroup;
	
	@NotNull
	@Column(name="group_name")
	private String groupName;
	
	@JsonIgnore
	@Column(name="id_employee")
	private int employee_id;

	

	@Override
	public String toString() {
		return "Post [id=" + idGroup + ", description=" + groupName + "]";
	}

	public Integer getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(Integer idGroup) {
		this.idGroup = idGroup;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}


}
