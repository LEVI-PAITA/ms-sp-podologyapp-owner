package com.sp.ms.podologyapp.owner.model.request;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestPodiatryCenter {
	
	private Long businessOwner;
	private String nameCenter;
	private String phone;
	private String address;
	private String email;
	private String photo;
	private String openingHours;
	private BigDecimal ranking;
	private String latitudeMaps;
	private String lengthMaps;
	private String idDepartment;
	private String idProvince;
	private String idDistrict;

}
