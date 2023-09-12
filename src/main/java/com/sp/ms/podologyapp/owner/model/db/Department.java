package com.sp.ms.podologyapp.owner.model.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "departments")
@Data
public class Department implements Serializable {
	
	@Id
	@Column(name = "id_department")
	private String idDepartament;
	
	@Column(name = "name")
	private String name;

}
