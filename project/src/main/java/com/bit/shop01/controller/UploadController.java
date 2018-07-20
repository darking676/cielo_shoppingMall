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

import com.bit.shop01.model.entity.MemVo;
import com.bit.shop01.util.MediaUtils;
import com.bit.shop01.util.UploadFileDisplay;
import com.bit.shop01.util.UploadFileUtils;

@Controller
public class UploadController {

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	@Resource(name = "uploadPath")
	private String uploadPath;

	@RequestMapping(value = "/upload/uploadForm", method = RequestMethod.GET)
	public void uploadForm() throws Exception {}

	@RequestMapping(value = "/upload/uploadForm", method = RequestMethod.POST)
	public String uploadForm(Model model, MultipartFile file) throws Exception {
		logger.info("이름: "+file.getOriginalFilename());
		logger.info("크기: "+file.getSize());
		logger.info("타입: "+file.getContentType());
		
		String savedName = uploadFile(file.getOriginalFilename(), file.getSize());
		
		model.addAttribute("savedName",savedName);
		
		return "uploadForm";
	}

	private String uploadFile(String originalFilename, long size) {
		return "";
	}

	private String uploadFile(String originalFilename, byte[] fileData) throws Exception {
		UUID uuid = UUID.randomUUID();
		String savedName = uuid.toString() + "_" + originalFilename;
		File target = new File(uploadPath, savedName);
		FileCopyUtils.copy(fileData, target);
		return savedName;
	}
	
	/*AJAX*/ 

	@RequestMapping(value = "/upload/uploadAjax", method = RequestMethod.GET)
	public String uploadAjax() {
		return "uploadAjax";
	}
	
	// text/plain;charset=UTF-8 => 파일 한글처리
	@ResponseBody
	@RequestMapping(value="/upload/uploadAjax", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String uploadAjax(MultipartFile file, Model model, HttpSession session,
			HttpServletRequest req, String str) throws Exception {
		logger.info("OriginalName: "+file.getOriginalFilename());
		ResponseEntity<String> img_path = new ResponseEntity<>(
				UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()),
				HttpStatus.CREATED);
		String user_imgPath = (String) img_path.getBody();
		
		logger.info(user_imgPath);
		MemVo vo = new MemVo();
		vo.setUser_profileImagePath(user_imgPath);
		MemVo id = (MemVo) session.getAttribute("login");
		System.out.println(id.getUser_id());
		vo.setUser_id(id.getUser_id());
		logger.info("FILE PATH: "+user_imgPath);
		
		return user_imgPath;
	}
	
	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {

		UploadFileDisplay display = UploadFileDisplay.getInstance();
		
		return display.display(fileName, uploadPath);
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteFile", method=RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String fileName){
		
		logger.info("delete file: " + fileName);
		
		String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
		MediaType mType = MediaUtils.getMediaType(formatName);
		//이미지 파일인 경우
		//이미지 원본 파일 삭제
		if(mType != null) {
			String front = fileName.substring(0, 12);
			String end = fileName.substring(14);
			new File(uploadPath+(front+end).replace('/', File.separatorChar)).delete();
		}
		//일반 파일 삭제, 썸네일 이미지 삭제
		new File(uploadPath+fileName.replace('/', File.separatorChar)).delete();
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}

}
