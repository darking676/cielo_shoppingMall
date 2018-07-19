package com.bit.shop01.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	@Resource(name = "uploadPath")
	private String uploadPath;

	@RequestMapping(value = "/uploadForm", method = RequestMethod.POST)
	public void uploadForm() throws Exception {}

	@RequestMapping(value = "/uploadForm", method = RequestMethod.POST)
	public String uploadForm(Model model, MultipartFile file) throws Exception {
		logger.info("�̸�"+file.getOriginalFilename());
		logger.info("ũ��"+file.getSize());
		logger.info("Ÿ��"+file.getContentType());
		
		String savedName = uploadFile(file.getOriginalFilename(), file.getSize());
		
		model.addAttribute("savedName",savedName);
		
		return "uploadResult";
	}

	private String uploadFile(String originalFilename, long size) {
		// TODO Auto-generated method stub
		return null;
	}

	private String uploadFile(String originalFilename, byte[] fileData) throws Exception {
		UUID uuid = UUID.randomUUID();
		String savedName = uuid.toString() + "_" + originalFilename;
		File target = new File(uploadPath, savedName);
		FileCopyUtils.copy(fileData, target);
		return savedName;
	}
	
	@ResponseBody
	@RequestMapping(value="", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String uploadAjaax(MultipartFile file, Model model, HttpSession session,
			HttpServletRequest req, String str) throws Exception {
		logger.info("OriginalName: "+file.getOriginalFilename());
		ResponseEntity<String> img_path = new ResponseEntity<>(
				UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()),
				HttpStatus.CREATED);
		String user_imgPath = (String) img_path.getBody();
		
		logger.info(user_imgPath);
		UserVo vo = new UserVo();
		vo.setUser_profileImagePath(user_imgPath);
		UserVo id = (UserVo) session.getAttribute("login");
		System.out.println(id.getUser_id());
		vo.setUser_id(id.getUser_id());
		logger.info("file name: "+user_imgPath);
		
		return user_imgPath;
	}
	
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {

		InputStream is = null;
		ResponseEntity<byte[]> entity = null;
		
		logger.info("FILE NAME: "+fileName);
		
		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
			MediaType mType = MediaUtils.getMediaType(formatName);
			HttpHeaders headers = new HttpHeaders();
			is = new FileInputStream(uploadPath+fileName);
			if(mType != null) {
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition", "attachment; filename=\""+new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
			}
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(is), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			is.close();
		}
		return entity;
	}
	
	public ResponseEntity<String> deleteFile(String fileName){
		
		logger.info("delete file: " + fileName);
		
		String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
		MediaType mType = MediaUtils.getMediaType(formatName);
		if(mType != null) {
			String front = fileName.substring(0, 12);
			String end = fileName.substring(14);
			new File(uploadPath+(front+end).replace('/', File.separatorChar)).delete();
		}
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
}