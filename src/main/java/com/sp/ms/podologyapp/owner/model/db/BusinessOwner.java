package com.sp.ms.podologyapp.owner.model.db;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "business_owner")
@Data
public class BusinessOwner implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_business")
	private Long idbusiness;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "ruc")
	private String ruc;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "mail")
	private String email;
	
	@Column(name = "foto")
	private String foto;
	
	@JoinColumn(name = "id_user")
	@JsonIgnore
	@ManyToOne
	private Usuario usuario;
	
	private static final long serialVersionUID = 1L;
	
}
