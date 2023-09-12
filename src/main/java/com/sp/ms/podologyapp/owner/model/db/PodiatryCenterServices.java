package com.sp.ms.podologyapp.owner.model.db;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "podiatry_center_services")
@Data
public class PodiatryCenterServices implements Serializable {
	
	@Id
	@Column(name = "id_podiatry_center")
	private PodiatryCenter podiatryCenter;
	
	@JoinColumn(name = "id_business")
	@JsonIgnore
	@ManyToOne
	private BusinessOwner businessOwner;
	
	@JoinColumn(name = "id_podiatry_serv")
	@JsonIgnore
	@ManyToOne
	private PodiatryServices podiatryServices;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "discount")
	private BigDecimal discount;
	
	@Column(name = "status")
	private String status;
	

	private static final long serialVersionUID = 1L;
}
