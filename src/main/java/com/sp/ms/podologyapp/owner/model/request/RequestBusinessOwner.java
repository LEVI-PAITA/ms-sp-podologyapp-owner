package com.sp.ms.podologyapp.owner.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestBusinessOwner {
	
	private String companyName;
	private String ruc;
	private String phone;
	private String address;
	private String email;
	//private String foto;
	private Long user;

}
