package com.mycompany.webapp.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.webapp.dto.Ch09User;


@Controller
@RequestMapping("/ch09")
public class Ch09Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch09Controller.class);
	
	@GetMapping("/content")
	public String content() {
		logger.info("실행");
		return "ch09/content";
	}
	
	@PostMapping("/photoupload")
	public String photoUpload(Ch09User user) {
		String uid = user.getUid();
		String uname = user.getUname();
		String upassword = user.getUpassword();
		logger.info("Id:" + uid);
		logger.info("Uname:" + uname);
		logger.info("Upassword:" + upassword);
		
		//파일 파트 정보 얻기
		MultipartFile uphoto = user.getUphoto();
		/*isEmpty() 없으면 true*/
		if (!uphoto.isEmpty())  {
		String originalFileName = uphoto.getOriginalFilename(); //DB에 저장될 때 사용 되는 이름
		String contentType = uphoto.getContentType();
		long size = uphoto.getSize();
		logger.info(originalFileName);
		logger.info(contentType);
		logger.info("size: " +size);
		
		//파일 경로
		String saveDirPath = "D:/MyWorkPlace/uploadfiles/";
		//파일 저장 이름
		//실제 저장 이름이고 DB에 저장될 때 사용되는 이름 (fileName)
		String fileName = new Date().getTime() + "-" + originalFileName; 
		String filePath = saveDirPath + fileName;
		File file = new File(filePath); //file의 경로를 갖고 있는 객체
		logger.info("file" + file);
			try {
				uphoto.transferTo(file); //파일 저장 
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
		return "redirect:/ch09/content";
		
		
	}
	
	@GetMapping("/photolist")
	public String photolist (Model model) {
		String saveDirPath = "D:/MyWorkPlace/uploadfiles/"; //파일이 있는 경로
		File dir = new File(saveDirPath);
		String[] fileNames = dir.list();
		model.addAttribute("fileNames", fileNames);
		return "ch09/photolist";
	}
	
	@GetMapping("/photodownload")
	/*
	 * public void photoDownload(String photo, HttpServletResponse response) {
	 * //응답으로 보내는 내용의 type과 문자 set
	 * response.setContentType("text/html; charset=UTF-8"); try { PrintWriter pw =
	 * response.getWriter(); pw.println("<html>"); pw.println(" 	<body>");
	 * pw.println(" 		photoDownload의 응답"); pw.println(" 	<body>");
	 * pw.println("<html>"); pw.flush(); pw.close(); } catch (IOException e) {
	 * e.printStackTrace(); } }
	 */
	//void라서 응답이 올 때까지 기다림
	public void photoDownload(String photo, HttpServletResponse response) {
		//응답으로 보내는 내용의 type과 문자 set
		String saveDirPath = "D:/MyWorkPlace/uploadfiles/";
		String filePath = saveDirPath + photo;
		
		//응답 본문 데이터의 종류를 응답 헤더에 추가 
		response.setContentType("image/jpeg");
		
		//응답 본문 데이터를 파일로 다운로드 (한글을 변환해주어야함)
		//http 규약에 따라 헤더에는 한글을 넣지 못함
		try {
			photo = new String(photo.getBytes("UTF-8"), "ISO-8859-1");
		} catch (Exception e1) {

			e1.printStackTrace();
		} 
		response.setHeader("Content-Disposition", "attachment; filename=\""+ photo +"\"");
		try {
			OutputStream os = response.getOutputStream();
			InputStream is = new FileInputStream(filePath);
			/*
			 * byte[] data = new byte[1024]; 
			 * while (true) { int readByteNum = is.read(data);
			 * if (readByteNum == -1) {break;} 
			 * os.write(data, 0 , readByteNum); }
			 */
			FileCopyUtils.copy(is,os);
			os.flush();
			os.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
