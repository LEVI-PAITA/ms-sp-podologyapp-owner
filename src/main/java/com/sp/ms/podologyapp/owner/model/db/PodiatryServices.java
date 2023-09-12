package com.sp.ms.podologyapp.owner.model.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "podiatry_services")
@Data
public class PodiatryServices implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_podiatry_serv")
	private Long idPodiatryServ;
	
	@Column( name = "name")
	private String name;
	
	@Column( name = "comentary")
	private String comentary;
	
	private static final long serialVersionUID = 1L;

}
