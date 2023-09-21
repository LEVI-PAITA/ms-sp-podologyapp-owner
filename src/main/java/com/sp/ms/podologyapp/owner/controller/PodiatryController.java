package com.sp.ms.podologyapp.owner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sp.ms.podologyapp.owner.business.PodiatryService;
import com.sp.ms.podologyapp.owner.model.db.PodiatryCenter;
import com.sp.ms.podologyapp.owner.model.db.PodiatryCenterServices;
import com.sp.ms.podologyapp.owner.model.db.PodiatryServices;
import com.sp.ms.podologyapp.owner.model.request.RequestPodiatry;
import com.sp.ms.podologyapp.owner.model.request.RequestPodiatryCenter;
import com.sp.ms.podologyapp.owner.model.request.RequestPodiatryCenterServ;
import com.sp.ms.podologyapp.owner.util.AppConstants;
import com.sp.ms.podologyapp.owner.util.ResponseInfoOwner;

@RestController
@RequestMapping("/api/owner")
public class PodiatryController {
	
	@Autowired
	private PodiatryService podiatryService;
	
	@PostMapping("/v1/podiatry/createServices")
	public ResponseInfoOwner<PodiatryServices> createPodiatry (@RequestBody RequestPodiatry requestPodiatry){
		
		ResponseInfoOwner<PodiatryServices> responseInfoOwner;
		
		try {
			
			responseInfoOwner = podiatryService.savePodiatryService(requestPodiatry);
			
		} catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
        	
        	responseInfoOwner = new ResponseInfoOwner<>();
        	responseInfoOwner.setResponseCode("1");
        	PodiatryServices emptyCharge = new PodiatryServices();
            responseInfoOwner.setResponseData(emptyCharge);
            responseInfoOwner.setResponseMessage(AppConstants.LOG_MESSAGE_CONTROLLER_ERROR + AppConstants.COLON
                    + AppConstants.SPACE + e.toString());
		}
		
		return responseInfoOwner;
		
	}
	
	@PostMapping("/v1/create/podiatryCenter")
	public ResponseEntity<PodiatryCenterServices> createPodiatryCenterServices(@RequestBody RequestPodiatryCenterServ requestPodiatryCenterServ){
		
		return podiatryService.savePodiatryCenterServices(requestPodiatryCenterServ);
		
	}

	
	@PostMapping("/v1/podiatry/create")
	public ResponseInfoOwner<PodiatryCenter> createPodiatryCenter(@Validated  @ModelAttribute RequestPodiatryCenter requestPodiatryCenter,
			@RequestParam("photo") MultipartFile photo){
		
		ResponseInfoOwner<PodiatryCenter> responseInfoOwner;
		
		try {
			
			responseInfoOwner = podiatryService.savePodiatryCenter(requestPodiatryCenter, photo);
			
		} catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
        	
        	responseInfoOwner = new ResponseInfoOwner<>();
        	responseInfoOwner.setResponseCode("1");
        	PodiatryCenter emptyCharge = new PodiatryCenter();
            responseInfoOwner.setResponseData(emptyCharge);
            responseInfoOwner.setResponseMessage(AppConstants.LOG_MESSAGE_CONTROLLER_ERROR + AppConstants.COLON
                    + AppConstants.SPACE + e.toString());
		}
		
		return responseInfoOwner;
		
	}
	
	@GetMapping("/v1/podiatry/get")
	public List<PodiatryCenter> getPodiatryCenter(){
		
		return podiatryService.getPodiatryCenter();
	}
}
