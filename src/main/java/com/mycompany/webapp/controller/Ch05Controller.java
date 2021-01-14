package com.mycompany.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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
	
}
