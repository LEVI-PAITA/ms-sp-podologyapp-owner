package com.sp.ms.podologyapp.owner.model.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "provinces")
@Data
public class Province implements Serializable {
	
	@Id
	@Column(name = "id_province")
	private String idProvince;
	
	@Column(name = "name")
	private String name;

	@JoinColumn(name = "id_department")
	@ManyToOne
	@JsonIgnore
	private Department department;
	
}
