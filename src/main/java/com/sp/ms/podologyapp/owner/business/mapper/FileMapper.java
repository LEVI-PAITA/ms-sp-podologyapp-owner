package com.sp.ms.podologyapp.owner.business.mapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileMapper {
	
	public String filePath(MultipartFile archivo) {
		
		Path diretorioImage = Paths.get("src//main//resources//static/images");
		String rutaAbsoluta = diretorioImage.toFile().getAbsolutePath();
		String nombreArchivo = null;
		
		try {
			byte[] byteImage = archivo.getBytes();
			nombreArchivo = UUID.randomUUID().toString() + "_" +  archivo.getOriginalFilename();
			
			Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + nombreArchivo);
			Files.write(rutaCompleta, byteImage);
			
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return nombreArchivo;
	}

}
