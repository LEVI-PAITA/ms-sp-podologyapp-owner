package com.sp.ms.podologyapp.owner.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sp.ms.podologyapp.owner.business.PodiatryService;
import com.sp.ms.podologyapp.owner.business.mapper.FileMapper;
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
import com.sp.ms.podologyapp.owner.util.AppConstants;
import com.sp.ms.podologyapp.owner.util.ResponseInfoOwner;

@Service
public class PodiatryServiceImpl implements PodiatryService{
	
	@Autowired
	private PodiatryRepository podiatryRepository;
	
	@Autowired
	private PodiatryCenterSerRepository podiatryCenterSerRepository;
	
	@Autowired
	private PodiatryCenterRepository centerRepository;
	
	@Autowired
	private FileMapper fileMapper;

	@Override
	public ResponseInfoOwner<PodiatryServices> savePodiatryService(RequestPodiatry podiatryRequest) {
		
		ResponseInfoOwner<PodiatryServices> responseInfoOwner = new ResponseInfoOwner<>();
		
		PodiatryServices podiatryObject = new PodiatryServices();
		
		try {
			
			podiatryObject.setName(podiatryRequest.getName());
			podiatryObject.setComentary(podiatryRequest.getComentary());
			
			podiatryRepository.save(podiatryObject);
			
			responseInfoOwner.setResponseCode("0");
			responseInfoOwner.setResponseData(podiatryObject);
			responseInfoOwner.setResponseMessage(AppConstants.MESSAGE_EXITO);
			
		} catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
			responseInfoOwner.setResponseCode("1");
			responseInfoOwner.setResponseData(podiatryObject);
			responseInfoOwner.setResponseMessage(
                    AppConstants.LOG_MESSAGE_SERVICE_ERROR + AppConstants.COLON + AppConstants.SPACE + e.toString());
		}
		
		return responseInfoOwner;
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
	public ResponseInfoOwner<PodiatryCenter> savePodiatryCenter(RequestPodiatryCenter requestCenter, 
			MultipartFile archivo) {
		
		ResponseInfoOwner<PodiatryCenter> responseInfoOwner = new ResponseInfoOwner<>();
		
		BusinessOwner businessOwner = new BusinessOwner();
		businessOwner.setIdbusiness(requestCenter.getBusinessOwner());
		
		PodiatryServices podiatryServices = new PodiatryServices();
		podiatryServices.setIdPodiatryServ(requestCenter.getPodiatryServices());
		
		Department department = new Department();
		department.setIdDepartament(requestCenter.getIdDepartment());
		
		Province province = new Province();
		province.setIdProvince(requestCenter.getIdProvince());
		
		District district = new District();
		district.setIdDistrict(requestCenter.getIdDistrict());
		
		PodiatryCenter podiatryCenter = new PodiatryCenter();
		podiatryCenter.setBusinessOwner(businessOwner);
		podiatryCenter.setPodiatryServices(podiatryServices);
		
		try {
			if(!archivo.isEmpty()) {
				
				String nombreArchivo = fileMapper.filePath(archivo);
				
				podiatryCenter.setNameCenter(requestCenter.getNameCenter());
				podiatryCenter.setPhone(requestCenter.getPhone());
				podiatryCenter.setAddress(requestCenter.getAddress());
				podiatryCenter.setEmail(requestCenter.getEmail());
				podiatryCenter.setPhoto(nombreArchivo);
				podiatryCenter.setOpeningHours(requestCenter.getOpeningHours());
				podiatryCenter.setRanking(requestCenter.getRanking());
				podiatryCenter.setLatitudeMaps(requestCenter.getLatitudeMaps());
				podiatryCenter.setLengthMaps(requestCenter.getLengthMaps());
				podiatryCenter.setPrice(requestCenter.getPrice());
				podiatryCenter.setDiscount(requestCenter.getDiscount());
				podiatryCenter.setStatus(requestCenter.getStatus());
				
				podiatryCenter.setDepartment(department);
				podiatryCenter.setProvince(province);
				podiatryCenter.setDistrict(district);
				
				centerRepository.save(podiatryCenter);
				
			}
			
			
			responseInfoOwner.setResponseCode("0");
			responseInfoOwner.setResponseData(podiatryCenter);
			responseInfoOwner.setResponseMessage(AppConstants.MESSAGE_EXITO);
			
		} catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
			responseInfoOwner.setResponseCode("1");
			responseInfoOwner.setResponseData(podiatryCenter);
			responseInfoOwner.setResponseMessage(
                    AppConstants.LOG_MESSAGE_SERVICE_ERROR + AppConstants.COLON + AppConstants.SPACE + e.toString());
		}
		
		return responseInfoOwner;
		
		
	}

	@Override
	public List<PodiatryCenter> getPodiatryCenter() {
		
		return centerRepository.findAll();
	}

}
