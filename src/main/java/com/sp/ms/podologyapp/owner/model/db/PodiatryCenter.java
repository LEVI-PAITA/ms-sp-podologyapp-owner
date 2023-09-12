package com.sp.ms.podologyapp.owner.model.db;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "podiatry_center")
@Data
public class PodiatryCenter implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_podiatry_center")
	private Long idPodiatryCenter;
	
	@JoinColumn(name = "id_business")
	@JsonIgnore
	@ManyToOne
	private BusinessOwner businessOwner;
	
	@Column(name = "name_center")
	private String nameCenter;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "mail")
	private String email;
	
	@Column(name = "foto")
	private String photo;
	
	@Column(name = "opening_hours")
	private String openingHours;
	
	@Column(name = "ranking")
	private BigDecimal ranking;
	
	@Column(name = "latitude_maps")
	private String latitudeMaps;
	
	@Column(name = "length_maps")
	private String lengthMaps;
	
	@JoinColumn(name = "id_department")
	@JsonIgnore
	@ManyToOne
	private Department department;
	
	@JoinColumn(name = "id_province")
	@JsonIgnore
	@ManyToOne
	private Province province;
	
	@JoinColumn(name = "id_district")
	@JsonIgnore
	@ManyToOne
	private District district;
	
	private static final long serialVersionUID = 1L;
	

}
