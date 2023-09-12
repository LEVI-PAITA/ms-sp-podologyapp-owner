package com.sp.ms.podologyapp.owner.business.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sp.ms.podologyapp.owner.business.BusinessOwnerService;
import com.sp.ms.podologyapp.owner.model.db.BusinessOwner;
import com.sp.ms.podologyapp.owner.model.db.Usuario;
import com.sp.ms.podologyapp.owner.model.request.RequestBusinessOwner;
import com.sp.ms.podologyapp.owner.repository.BusinessOwnerRepository;

@Service
public class BusinessOwnerServiceImpl implements BusinessOwnerService{
	
	
	@Autowired
	private BusinessOwnerRepository ownerRepository;

	@Override
	public ResponseEntity<BusinessOwner> saveBusinessOwner(RequestBusinessOwner requestBusinessOwner, MultipartFile archivo) {
		
		BusinessOwner businessOwner = new BusinessOwner();
		Usuario usuario = new Usuario();
		usuario.setIdUser(requestBusinessOwner.getUser());
		
		if(!archivo.isEmpty()) {
			
			Path diretorioImage = Paths.get("src//main//resources//static/images");
			String rutaAbsoluta = diretorioImage.toFile().getAbsolutePath();
			
			try {
				byte[] byteImage = archivo.getBytes();
				String nombreArchivo = UUID.randomUUID().toString() + "_" +  archivo.getOriginalFilename();
				
				Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + nombreArchivo);
				Files.write(rutaCompleta, byteImage);
				
				businessOwner.setFoto(nombreArchivo);
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			businessOwner.setCompanyName(requestBusinessOwner.getCompanyName());
			businessOwner.setRuc(requestBusinessOwner.getRuc());
			businessOwner.setPhone(requestBusinessOwner.getPhone());
			businessOwner.setAddress(requestBusinessOwner.getAddress());
			businessOwner.setEmail(requestBusinessOwner.getEmail());
			businessOwner.setUsuario(usuario);
			
		}
		
		ownerRepository.save(businessOwner);
		
		return new ResponseEntity<>(businessOwner, HttpStatus.OK);
		
	}
	

}
