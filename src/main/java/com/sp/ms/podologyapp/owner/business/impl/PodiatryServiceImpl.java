package com.sp.ms.podologyapp.owner.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sp.ms.podologyapp.owner.business.PodiatryService;
import com.sp.ms.podologyapp.owner.model.db.BusinessOwner;
import com.sp.ms.podologyapp.owner.model.db.Department;
import com.sp.ms.podologyapp.owner.model.db.District;
import com.sp.ms.podologyapp.owner.model.db.PodiatryCenter;
import com.sp.ms.podologyapp.owner.model.db.PodiatryCenterServices;
import com.sp.ms.podologyapp.owner.model.db.PodiatryServices;
import com.sp.ms.podologyapp.owner.model.db.Province;
import com.sp.ms.podologyapp.owner.model.request.RequestPodiatry;
import com.sp.ms.podologyapp.owner.model.request.RequestPodiatryCenter;
import com.sp.ms.podologyapp.owner.model.request.RequestPodiatryCenterServ;
import com.sp.ms.podologyapp.owner.repository.PodiatryCenterRepository;
import com.sp.ms.podologyapp.owner.repository.PodiatryCenterSerRepository;
import com.sp.ms.podologyapp.owner.repository.PodiatryRepository;

@Service
public class PodiatryServiceImpl implements PodiatryService{
	
	@Autowired
	private PodiatryRepository podiatryRepository;
	
	@Autowired
	private PodiatryCenterSerRepository podiatryCenterSerRepository;
	
	@Autowired
	private PodiatryCenterRepository centerRepository;

	@Override
	public ResponseEntity<PodiatryServices> savePodiatryService(RequestPodiatry podiatryRequest) {
		
		PodiatryServices podiatryObject = new PodiatryServices();
		podiatryObject.setName(podiatryRequest.getName());
		podiatryObject.setComentary(podiatryRequest.getComentary());
		
		podiatryRepository.save(podiatryObject);
		
		return new ResponseEntity<>(podiatryObject, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<PodiatryCenterServices> savePodiatryCenterServices(
			RequestPodiatryCenterServ requestPodiatryCenter) {
		
		PodiatryCenter podiatryCenter = new PodiatryCenter();
		podiatryCenter.setIdPodiatryCenter(requestPodiatryCenter.getPodiatryCenter());
		
		BusinessOwner businessOwner = new BusinessOwner();
		businessOwner.setIdbusiness(requestPodiatryCenter.getBusinessOwner());
		
		PodiatryServices podiatryServices = new PodiatryServices();
		podiatryServices.setIdPodiatryServ(requestPodiatryCenter.getPodiatryServices());
		
		PodiatryCenterServices podiatryCenterServices = new PodiatryCenterServices();
		//podiatryCenterServices.setPodiatryCenter(podiatryCenter);
		//podiatryCenterServices.setBusinessOwner(businessOwner);
		//podiatryCenterServices.setPodiatryServices(podiatryServices);
		podiatryCenterServices.setPrice(requestPodiatryCenter.getPrice());
		podiatryCenterServices.setDiscount(requestPodiatryCenter.getDiscount());
		podiatryCenterServices.setStatus(requestPodiatryCenter.getStatus());
		
		podiatryCenterSerRepository.save(podiatryCenterServices);
		
		return new ResponseEntity<>(podiatryCenterServices, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<PodiatryCenter> savePodiatryCenter(RequestPodiatryCenter requestCenter) {
		
		BusinessOwner businessOwner = new BusinessOwner();
		businessOwner.setIdbusiness(requestCenter.getBusinessOwner());
		
		Department department = new Department();
		department.setIdDepartament(requestCenter.getIdDepartment());
		
		Province province = new Province();
		province.setIdProvince(requestCenter.getIdProvince());
		
		District district = new District();
		district.setIdDistrict(requestCenter.getIdDistrict());
		
		PodiatryCenter podiatryCenter = new PodiatryCenter();
		podiatryCenter.setBusinessOwner(businessOwner);
		podiatryCenter.setNameCenter(requestCenter.getNameCenter());
		podiatryCenter.setPhone(requestCenter.getPhone());
		podiatryCenter.setAddress(requestCenter.getAddress());
		podiatryCenter.setEmail(requestCenter.getEmail());
		podiatryCenter.setPhoto(requestCenter.getPhoto());
		podiatryCenter.setOpeningHours(requestCenter.getOpeningHours());
		podiatryCenter.setRanking(requestCenter.getRanking());
		podiatryCenter.setLatitudeMaps(requestCenter.getLatitudeMaps());
		podiatryCenter.setLengthMaps(requestCenter.getLengthMaps());
		podiatryCenter.setDepartment(department);
		podiatryCenter.setProvince(province);
		podiatryCenter.setDistrict(district);
		
		centerRepository.save(podiatryCenter);
		
		return new ResponseEntity<>(podiatryCenter, HttpStatus.OK);
	}

}
