package com.sp.ms.podologyapp.owner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sp.ms.podologyapp.owner.business.BusinessOwnerService;
import com.sp.ms.podologyapp.owner.model.db.BusinessOwner;
import com.sp.ms.podologyapp.owner.model.request.RequestBusinessOwner;

@RestController
@RequestMapping("/api/owner")
public class BusinessOwnerController {
	
	@Autowired
	private BusinessOwnerService ownerService;
	
	@PostMapping("/v1/create/business")
	public ResponseEntity<BusinessOwner>createBusinessOwner(@Validated  @ModelAttribute RequestBusinessOwner requestOwner,
			@RequestParam("archivo") MultipartFile archivo){
		
		return ownerService.saveBusinessOwner(requestOwner, archivo);
		
	}

}
