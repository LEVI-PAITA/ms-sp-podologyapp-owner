package com.sp.ms.podologyapp.owner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sp.ms.podologyapp.owner.business.BusinessOwnerService;
import com.sp.ms.podologyapp.owner.model.db.BusinessOwner;
import com.sp.ms.podologyapp.owner.model.request.RequestBusinessOwner;
import com.sp.ms.podologyapp.owner.util.AppConstants;
import com.sp.ms.podologyapp.owner.util.ResponseInfoOwner;

@RestController
@RequestMapping("/api/owner")
public class BusinessOwnerController {

	@Autowired
	private BusinessOwnerService ownerService;

	@PostMapping("/v1/business/create")
	public ResponseInfoOwner<BusinessOwner> createBusinessOwner(
			@Validated @ModelAttribute RequestBusinessOwner requestOwner,
			@RequestParam("archivo") MultipartFile archivo) {

		ResponseInfoOwner<BusinessOwner> responseInfoOwner;

		try {

			responseInfoOwner = ownerService.saveBusinessOwner(requestOwner, archivo);

		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {

			responseInfoOwner = new ResponseInfoOwner<>();
			responseInfoOwner.setResponseCode("1");
			BusinessOwner emptyCharge = new BusinessOwner();
			responseInfoOwner.setResponseData(emptyCharge);
			responseInfoOwner.setResponseMessage(
					AppConstants.LOG_MESSAGE_CONTROLLER_ERROR + AppConstants.COLON + AppConstants.SPACE + e.toString());
		}

		return responseInfoOwner;

	}
	
	@GetMapping("/v1/business/get")
	public List<BusinessOwner> getBusinessOwner(){
		
		return ownerService.getBusinessOwner();
		
	}

}
