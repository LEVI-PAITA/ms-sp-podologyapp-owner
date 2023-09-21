package com.sp.ms.podologyapp.owner.model.request;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestPodiatryCenter {
	
	private Long businessOwner;
	private Long podiatryServices;
	private String nameCenter;
	private String phone;
	private String address;
	private String email;
	private String openingHours;
	private BigDecimal ranking;
	private String latitudeMaps;
	private String lengthMaps;
	private BigDecimal price;
	private BigDecimal discount;
	private String status;
	private String idDepartment;
	private String idProvince;
	private String idDistrict;

}
