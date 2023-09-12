package com.sp.ms.podologyapp.owner.model.request;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestPodiatryCenterServ {
	
	private Long podiatryCenter;
	private Long businessOwner;
	private Long podiatryServices;
	private BigDecimal price;
	private BigDecimal discount;
	private String status;

}
