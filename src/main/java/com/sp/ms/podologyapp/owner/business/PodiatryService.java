package com.sp.ms.podologyapp.owner.business;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.sp.ms.podologyapp.owner.model.db.PodiatryCenter;
import com.sp.ms.podologyapp.owner.model.db.PodiatryCenterServices;
import com.sp.ms.podologyapp.owner.model.db.PodiatryServices;
import com.sp.ms.podologyapp.owner.model.request.RequestPodiatry;
import com.sp.ms.podologyapp.owner.model.request.RequestPodiatryCenter;
import com.sp.ms.podologyapp.owner.model.request.RequestPodiatryCenterServ;
import com.sp.ms.podologyapp.owner.util.ResponseInfoOwner;

public interface PodiatryService {
	
	ResponseInfoOwner<PodiatryServices> savePodiatryService(RequestPodiatry podiatryRequest);
	
	ResponseEntity<PodiatryCenterServices> savePodiatryCenterServices(RequestPodiatryCenterServ requestPodiatryCenter);
	
	ResponseInfoOwner<PodiatryCenter> savePodiatryCenter(RequestPodiatryCenter requestCenter, MultipartFile multipartFile);
	
	List<PodiatryCenter> getPodiatryCenter();

}
