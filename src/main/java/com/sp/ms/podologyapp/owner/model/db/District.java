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
@Table(name = "districts")
@Data
public class District implements Serializable {
	
	@Id
	@Column(name = "id_district")
	private String idDistrict;
	
	@Column(name = "name")
	private String name;
	
	@JoinColumn(name = "id_province")
	@ManyToOne
	@JsonIgnore
	private Province province;
	
	@JoinColumn(name = "id_department")
	@ManyToOne
	@JsonIgnore
	private Department department;
	

}
