package com.bit.shop01.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {

	private static final Logger logger = LoggerFactory.getLogger(UploadFileUtils.class);
	
	public static String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception {
		UUID uuid = UUID.randomUUID(); //UUID 발급
		String savedName = uuid.toString()+"_"+originalName; //저장할 파일명 = UUID + 원본이름
		String savedPath = calcPath(uploadPath); //업로드할 디렉토리 생성
		File target = new File(uploadPath+savedPath, savedName); //파일 경로
		FileCopyUtils.copy(fileData, target); //임시 디렉토리에 업로드된 파일을 디렉토리에 복사
		String formatName = originalName.substring(originalName.lastIndexOf(".")+1); //파일 확장자 검사
		String uploadFileName = null;
		if(MediaUtils.getMediaType(formatName) != null) {		// 이미지 파일은 썸네일 사용
			uploadFileName = makeThumbnail(uploadPath, savedPath, savedName); //썸네일 생성
		}else {
			uploadFileName = makeIcon(uploadPath, savedPath, savedName); //아이콘 생성
		}
		
		return uploadFileName;
	}

	//아이콘 생성
	private static String makeIcon(String uploadPath, String path, String fileName) {
		String iconName = uploadPath + path + File.separator + fileName;
		return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}

	//썸네일 생성
	private static String makeThumbnail(String uploadPath, String path, String fileName) throws Exception {
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath + path, fileName));
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);
		String thumbnailName = uploadPath + path + File.separator + "s_" + fileName;
		File newFile = new File(thumbnailName);
		String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}

	//날짜별 디렉토리 생성
	private static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		String yearPath = File.separator+cal.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		makeDir(uploadPath, yearPath, monthPath, datePath);
		logger.info(datePath);
		return datePath;
	}

	//디렉토리 생성
	private static void makeDir(String uploadPath, String yearPath, String ...paths) {
		
		if(new File(paths[paths.length-1]).exists()) {		//디렉토리가 존재하면 ...
			return;
		}
		
		//디렉토리가 존재 않으면 ...
		for(String path : paths) {
			File dirPath = new File(uploadPath + path);
			if(! dirPath.exists()) {
				dirPath.mkdir();
			}
		}
	}
}