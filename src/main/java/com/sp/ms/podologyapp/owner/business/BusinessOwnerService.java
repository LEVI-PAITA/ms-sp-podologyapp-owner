package com.sp.ms.podologyapp.owner.business;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sp.ms.podologyapp.owner.model.db.BusinessOwner;
import com.sp.ms.podologyapp.owner.model.request.RequestBusinessOwner;
import com.sp.ms.podologyapp.owner.util.ResponseInfoOwner;

public interface BusinessOwnerService {

	ResponseInfoOwner<BusinessOwner> saveBusinessOwner(RequestBusinessOwner requestBusinessOwner, MultipartFile archivo);
	List<BusinessOwner> getBusinessOwner();
	
}
