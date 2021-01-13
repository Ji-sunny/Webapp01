package com.mycompany.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//controller밑은 무조건 requestMappting즉 공통경로는 지정해주어야함
@Controller
@RequestMapping("/ch02")
public class Ch02Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch02Controller.class);
	
	@RequestMapping("/content")
	public String content() {
		logger.info("ch02 실행");
		return "ch02/content";
	}
	//@RequestMapping("/request1") //GET하고 POST를 둘다 지원함
	@RequestMapping(value="/getMethod", method = RequestMethod.GET)
	public String getMethod() {
		logger.info("ch02 실행");
		return "ch02/content";
	}
	@RequestMapping(value="/postMethod", method = RequestMethod.POST)
	public String postMethod() {
		logger.info("ch02 실행");
		return "ch02/content";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String joinForm() {
		logger.info("회원가입 양식");
		return "ch02/joinForm";
	}
	
	//@RequestMapping(value="/join", method = RequestMethod.POST)
	@PostMapping("/join")
	public String join() {
		logger.info("회원가입 완료");
		return "ch02/content";
	}
	//@RequestMapping(value = "/joinAsync", method = RequestMethod.GET)
	@GetMapping("/joinAsync")
	public String joinFormAsync() {
		logger.info("회원가입 양식");
		return "ch02/joinFormAsync";
	}
}
