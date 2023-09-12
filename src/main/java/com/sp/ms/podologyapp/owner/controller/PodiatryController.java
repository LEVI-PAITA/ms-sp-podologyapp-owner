package com.sp.ms.podologyapp.owner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.ms.podologyapp.owner.business.PodiatryService;
import com.sp.ms.podologyapp.owner.model.db.PodiatryCenter;
import com.sp.ms.podologyapp.owner.model.db.PodiatryCenterServices;
import com.sp.ms.podologyapp.owner.model.db.PodiatryServices;
import com.sp.ms.podologyapp.owner.model.request.RequestPodiatry;
import com.sp.ms.podologyapp.owner.model.request.RequestPodiatryCenter;
import com.sp.ms.podologyapp.owner.model.request.RequestPodiatryCenterServ;

@RestController
@RequestMapping("/api/owner")
public class PodiatryController {
	
	@Autowired
	private PodiatryService podiatryService;
	
	@PostMapping("/v1/create/podiatryServices")
	public ResponseEntity<PodiatryServices> createPodiatry (@RequestBody RequestPodiatry requestPodiatry){
		
		return podiatryService.savePodiatryService(requestPodiatry);
		
	}
	
	@PostMapping("/v1/create/podiatryCenter")
	public ResponseEntity<PodiatryCenterServices> createPodiatryCenterServices(@RequestBody RequestPodiatryCenterServ requestPodiatryCenterServ){
		
		return podiatryService.savePodiatryCenterServices(requestPodiatryCenterServ);
		
	}

	
	@PostMapping("/v1/create/podiatry")
	public ResponseEntity<PodiatryCenter> createPodiatryCenter(@RequestBody RequestPodiatryCenter requestPodiatryCenter ){
		
		return podiatryService.savePodiatryCenter(requestPodiatryCenter);
		
	}
}
