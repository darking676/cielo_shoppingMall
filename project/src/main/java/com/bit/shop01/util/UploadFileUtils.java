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
	
	private static Integer WIDTH_SIZE=100;
	
	public static Integer getWIDTH_SIZE() {
		return WIDTH_SIZE;
	}
	
	public static void setWIDTH_SIZE(Integer wIDTH_SIZE) {
		WIDTH_SIZE = wIDTH_SIZE;
	}
	
	//������ ������(uploadPath), ���� �̸�(originalName), ���� ������(byte[])
	public static String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception {
		UUID uuid = UUID.randomUUID(); //UUID �߱�
		String savedName = uuid.toString()+"_"+originalName; //������ ���ϸ� = UUID + �����̸�
		
		String savedPath = calcPath(uploadPath); //���ε��� ���丮 ����
		
		File target = new File(uploadPath+savedPath, savedName); //���� ���
		FileCopyUtils.copy(fileData, target); //�ӽ� ���丮�� ���ε�� ������ ���丮�� ����
		
		String formatName = originalName.substring(originalName.lastIndexOf(".")+1); //���� Ȯ���� �˻�
		String uploadFileName = null;
		
		if(MediaUtils.getMediaType(formatName) != null) {		// �̹��� ������ ����� ���
			uploadFileName = makeThumbnail(uploadPath, savedPath, savedName); //����� ����
		}else {
			uploadFileName = makeIcon(uploadPath, savedPath, savedName); //������ ����
		}
		
		return uploadFileName;
	}

	//������ ����(�̹����� �ƴ� ��� ���� ��θ� url �ּҷ� ��ȯ)
	private static String makeIcon(String uploadPath, String path, String fileName) {
		String iconName = uploadPath + path + File.separator + fileName;
		return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}

	//����� ����(���ϰ��, ����� ���, ���� �̸�)
	private static String makeThumbnail(String uploadPath, String path, String fileName) throws Exception {
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath + path, fileName));
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);
		String thumbnailName = uploadPath + path + File.separator + "s_" + fileName;
		File newFile = new File(thumbnailName);
		String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}

	//��¥�� ���丮 ����
	private static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		String yearPath = File.separator+cal.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		makeDir(uploadPath, yearPath, monthPath, datePath);
		logger.info(datePath);
		return datePath;
	}

	//���丮(��¥ ����) ����
	private static void makeDir(String uploadPath, String yearPath, String ...paths) {
		
		//���丮�� �����ϸ� ...
		if(new File(paths[paths.length-1]).exists()) {		
			return;
		}
		
		//���丮�� ���� ������ ...
		for(String path : paths) {
			File dirPath = new File(uploadPath + path);
			if(! dirPath.exists()) {
				dirPath.mkdir();
			}
		}
	}
}