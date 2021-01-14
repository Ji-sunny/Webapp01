package com.mycompany.webapp.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ch05")
public class Ch05Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch05Controller.class);
	
	@GetMapping("/content")
	public String content() {
		logger.info("실행");
		return "ch05/content";
	}
	
	@GetMapping("/method1")
	public String method1(@RequestHeader("User-Agent") String userAgent) {
		logger.info("실행");
		//logger.info(userAgent);
		if (userAgent.contains("Edg")) {
			logger.info("Edg");
		} else if (userAgent.contains("Chrome")){
			logger.info("Chrome");
		} else if (userAgent.contains("Trident/7.0")) {
			logger.info("IE11");
		} else if (userAgent.contains("MSIE")) {
			logger.info("IE10 이하");
		}
		return "ch05/content";
	}
	
	@GetMapping("/method2")
	public String method2(HttpServletRequest request) {
		logger.info("실행");
		String userAgent = request.getHeader("User-Agent");
		//logger.info(userAgent);
		if (userAgent.contains("Edg")) {
			logger.info("Edg");
		} else if (userAgent.contains("Chrome")){
			logger.info("Chrome");
		} else if (userAgent.contains("Trident/7.0")) {
			logger.info("IE11");
		} else if (userAgent.contains("MSIE")) {
			logger.info("IE10 이하");
		}
		return "ch05/content";
	}
	
	@GetMapping("/method3")
	public String method3(HttpServletRequest request, 
							HttpServletResponse response) {
		//쿠키 생성
		Cookie cookie1 = new Cookie("memberId", "white");
		Cookie cookie2 = new Cookie("loginStatus", "ok");
		//쿠키를 응답 헤더에 포함시켜 browser에 보내기
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		//응답 본문을 생성하는 뷰 리턴
		return "ch05/content";
	}
	
	@GetMapping("/method4")
	public String method4(HttpServletRequest request, 
							HttpServletResponse response) {
		//브라우저가 요청 헤더에 보낸 쿠키값읽기
		Cookie [] cookieArr = request.getCookies();
		for (Cookie cookie : cookieArr) {
			String name = cookie.getName();
			String value = cookie.getValue();
			logger.info(name +": "+ value);
		}
		//응답 본문을 생성하는 뷰 리턴
		return "ch05/content";
	}
	
	@GetMapping("/method5")
	public String method5(
			//쿠키 이름과 변수의 이름이 같으면 annotation값을 생략가능
			//@CookieValue("memberId") String memberId, 
			@CookieValue String memberId, 
			@CookieValue String loginStatus) {

		logger.info("memberId: "+memberId);
		logger.info("loginStatus: "+loginStatus);
		//응답 본문을 생성하는 뷰 리턴
		return "ch05/content";
	}
	
	
}
