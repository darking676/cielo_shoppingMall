package com.bit.shop01.util;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class UploadFileDisplay {

	private static final Logger logger = LoggerFactory.getLogger(UploadFileDisplay.class);
	
	private static UploadFileDisplay instance;
	
	//Singleton
	private UploadFileDisplay() {}
	
	public static UploadFileDisplay getInstance() {
		if(instance == null) {
			instance = new UploadFileDisplay();
		}
		return instance;
	}
	
	public ResponseEntity<byte[]> display(String fileName, String uploadPath) throws Exception {
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		logger.info("File Name : "+fileName);
		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
			MediaType mType = MediaUtils.getMediaType(formatName);
			HttpHeaders headers = new HttpHeaders();
			
			in = new FileInputStream(uploadPath+fileName);
			if(mType != null) {
				headers.setContentType(mType);
			}else {
				fileName = fileName.substring(fileName.indexOf("_")+1);
				String attach = "\""+new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"";
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("COntent-Disposition", "attachment; filename="+attach);
			}
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}
	
}
