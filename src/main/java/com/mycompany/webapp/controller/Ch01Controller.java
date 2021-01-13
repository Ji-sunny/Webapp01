package com.mycompany.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//http://.../webapp1/ch01/...
@Controller
@RequestMapping("/ch01")
public class Ch01Controller {
	private static final Logger logger = 
			LoggerFactory.getLogger(Ch01Controller.class);
	
//http://.../webapp1/ch01/content
	@RequestMapping("/content")
	public String content () {
		logger.info("content 실행");
		return "ch01/content";
	}
	
}
