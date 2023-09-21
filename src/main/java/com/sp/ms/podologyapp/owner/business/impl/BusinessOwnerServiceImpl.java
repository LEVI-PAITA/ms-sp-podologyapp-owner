package com.sp.ms.podologyapp.owner.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sp.ms.podologyapp.owner.business.BusinessOwnerService;
import com.sp.ms.podologyapp.owner.business.mapper.FileMapper;
import com.sp.ms.podologyapp.owner.model.db.BusinessOwner;
import com.sp.ms.podologyapp.owner.model.db.Usuario;
import com.sp.ms.podologyapp.owner.model.request.RequestBusinessOwner;
import com.sp.ms.podologyapp.owner.repository.BusinessOwnerRepository;
import com.sp.ms.podologyapp.owner.util.AppConstants;
import com.sp.ms.podologyapp.owner.util.ResponseInfoOwner;

@Service
public class BusinessOwnerServiceImpl implements BusinessOwnerService {

	@Autowired
	private BusinessOwnerRepository ownerRepository;

	@Autowired
	private FileMapper fileMapper;

	@Override
	public ResponseInfoOwner<BusinessOwner> saveBusinessOwner(RequestBusinessOwner requestBusinessOwner,
			MultipartFile archivo) {

		ResponseInfoOwner<BusinessOwner> responseInfoOwner = new ResponseInfoOwner<>();

		BusinessOwner businessOwner = new BusinessOwner();
		Usuario usuario = new Usuario();
		usuario.setIdUser(requestBusinessOwner.getUser());

		try {
			if (!archivo.isEmpty()) {

				String nombreArchivo = fileMapper.filePath(archivo);

				businessOwner.setFoto(nombreArchivo);
				businessOwner.setCompanyName(requestBusinessOwner.getCompanyName());
				businessOwner.setRuc(requestBusinessOwner.getRuc());
				businessOwner.setPhone(requestBusinessOwner.getPhone());
				businessOwner.setAddress(requestBusinessOwner.getAddress());
				businessOwner.setEmail(requestBusinessOwner.getEmail());
				businessOwner.setUsuario(usuario);

				ownerRepository.save(businessOwner);

			}
			
			responseInfoOwner.setResponseCode("0");
			responseInfoOwner.setResponseData(businessOwner);
			responseInfoOwner.setResponseMessage(AppConstants.MESSAGE_EXITO);

		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			responseInfoOwner.setResponseCode("1");
			responseInfoOwner.setResponseData(businessOwner);
			responseInfoOwner.setResponseMessage(
					AppConstants.LOG_MESSAGE_SERVICE_ERROR + AppConstants.COLON + AppConstants.SPACE + e.toString());
		}

		return responseInfoOwner;

	}

	@Override
	public List<BusinessOwner> getBusinessOwner() {

		return ownerRepository.findAll();
	}

}
