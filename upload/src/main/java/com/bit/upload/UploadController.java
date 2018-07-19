package com.bit.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	@Resource(name="uploadPath")
	String uploadPath;
	
	@RequestMapping(value="/upload/uploadForm",method = RequestMethod.POST)
	public void uploadForm() {}
	
	public ModelAndView uploadForm(MultipartFile file, ModelAndView mav) throws Exception {
		String savedName = file.getOriginalFilename();
		logger.info("파일이름 : "+file.getOriginalFilename());
		logger.info("파일크기"+file.getSize());
		logger.info("컨텐트 타입"+file.getContentType());
		
		savedName = uploadFile(savedName, file.getBytes());
		mav.setViewName("upload/uploadResult");
		mav.addObject("savedName", savedName);

		return mav;// 결과화면으로 포워딩
	}

	private String uploadFile(String originalName, byte[] fileData) throws Exception {
		UUID uuid = UUID.randomUUID();
		String savedName = uuid.toString() + "_" + originalName;
		File target = new File(uploadPath, savedName);
		FileCopyUtils.copy(fileData, target);
		
		return savedName;
	}
	
	/*AJAX*/
	
	@RequestMapping(value="/uploading/uploadAjax", method = RequestMethod.GET)
	public void uploadAjax() {
		// uploadAjax.jsp로 포워딩
	}
	
	@ResponseBody
	@RequestMapping(value = "/uploading/uploadAjax", method = RequestMethod.POST, produces = "text/plain; charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception {
		logger.info("originalName : "+file.getOriginalFilename());
		logger.info("size : "+file.getSize());
		logger.info("contentType : "+file.getContentType());
		
		return new ResponseEntity<String>(
				UploadFileUtils.uploadFile(uploadPath, 
				file.getOriginalFilename(),
				file.getBytes(), HttpStatus.OK));
	}
	
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
			MediaType mType = MediaUtils.getMediaType(formatName);
			HttpHeaders headers = new HttpHeaders();
			in = new FileInputStream(uploadPath + fileName);
			if(mType != null) {
				headers.setContentType(mType);
			} else {
				fileName = fileName.substring(fileName.indexOf("_") + 1);
				// 다운용 컨텐트 타입
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition", "attachment; filename=\""+new String(fileName.getBytes("utf-8"), "ISO-8859-1")+"\"");
			}
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			//HTTP Status Code
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		
		return entity;
	}
	
	public ResponseEntity<String> deleteFile(String fileName) {
		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
		MediaType mType = MediaUtils.getMediaType(formatName);
		return null;
	}
	
}
