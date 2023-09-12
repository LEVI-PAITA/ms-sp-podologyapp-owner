package com.sp.ms.podologyapp.owner.business;

import org.springframework.http.ResponseEntity;

import com.sp.ms.podologyapp.owner.model.db.PodiatryCenter;
import com.sp.ms.podologyapp.owner.model.db.PodiatryCenterServices;
import com.sp.ms.podologyapp.owner.model.db.PodiatryServices;
import com.sp.ms.podologyapp.owner.model.request.RequestPodiatry;
import com.sp.ms.podologyapp.owner.model.request.RequestPodiatryCenter;
import com.sp.ms.podologyapp.owner.model.request.RequestPodiatryCenterServ;

public interface PodiatryService {
	
	ResponseEntity<PodiatryServices> savePodiatryService(RequestPodiatry podiatryRequest);
	
	ResponseEntity<PodiatryCenterServices> savePodiatryCenterServices(RequestPodiatryCenterServ requestPodiatryCenter);
	
	ResponseEntity<PodiatryCenter> savePodiatryCenter(RequestPodiatryCenter requestCenter);

}
