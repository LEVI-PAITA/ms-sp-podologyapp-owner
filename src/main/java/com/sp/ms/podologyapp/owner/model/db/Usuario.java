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
@Table(name = "users")
@Data
public class Usuario implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_user")
	private Long idUser;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "names")
	private String name;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "dni")
	private String dni;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "estado")
	private Boolean estado;
	
	
	private static final long serialVersionUID = 1L;
	
	
}
