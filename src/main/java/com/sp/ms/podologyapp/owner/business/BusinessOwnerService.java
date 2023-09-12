package com.sp.ms.podologyapp.owner.business;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.sp.ms.podologyapp.owner.model.db.BusinessOwner;
import com.sp.ms.podologyapp.owner.model.request.RequestBusinessOwner;

public interface BusinessOwnerService {

	ResponseEntity<BusinessOwner> saveBusinessOwner(RequestBusinessOwner requestBusinessOwner, MultipartFile archivo);
	
}
