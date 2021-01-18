package com.mycompany.webapp.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.webapp.service.Ch13Service1;
import com.mycompany.webapp.service.Ch13Service2;
import com.mycompany.webapp.service.Ch13Service3;
import com.mycompany.webapp.service.Ch13Service4;
import com.mycompany.webapp.service.Ch13Service5;
import com.mycompany.webapp.service.Ch13Service6;
import com.mycompany.webapp.service.Ch13Service7;

@Controller
@RequestMapping("/ch13")
public class Ch13Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch13Controller.class);
	//Field------------방법1--------
	
	/* 관리개개체중에서 아래와 같은 타입으로 만든 객체가 있는지 확인 > dispatcher에서 bean(객체)를 만들어놈 */
	@Resource
	private Ch13Service1 service1;
	
	@Resource
	private Ch13Service2 service2;
	
	
	private Ch13Service3 service3;
	
	private Ch13Service4 service4;
	
	@Resource private Ch13Service5 service5;
	@Resource private Ch13Service6 service6;
	@Resource private Ch13Service7 service7;
	//constructor-----방법2----------
	/* 객체를 만들때 매개값이 IoC가 관리하는 객체가 있는 지 확인 하고 가져와서 사용함 */
	
	/*
	 * @Autowired public Ch13Controller(Ch13Service1 service1, Ch13Service2 service2
	 * ) { this.service1 = service1; this.service2 = service2; }
	 */
	 
	
	//method----------방법3--------
	/*
	 * @Autowired public void setService1(Ch13Service1 service1) { this.service1 =
	 * service1; logger.info("setService1()"); }
	 * 
	 * @Autowired public void setService2(Ch13Service2 service2) { this.service2 =
	 * service2; logger.info("setService2()"); }
	 */
	

	public void setService3(Ch13Service3 service3) { 
	this.service3 = service3; logger.info("setService3()"); 
	}
	
	public void setService4(Ch13Service4 service4) { 
	this.service4 = service4; 
	logger.info("setService4()"); 
	}
	
	
	@GetMapping("/content")
	public String content() {
		logger.info("실행");
		return "ch13/content";
	}	

	@GetMapping("/service1")
	public String service1() {
		service1.method();
		return "redirect:/ch13/content";
	}

	@GetMapping("/service2")
	public String service2() {
		service2.method();
		return "redirect:/ch13/content";
	}
	

	@GetMapping("/service3")
	public String service3() {
		service3.method();
		return "redirect:/ch13/content";
	}

	@GetMapping("/service4")
	public String service4() {
		service4.method();
		return "redirect:/ch13/content";
	}
	
	
	@GetMapping("/service5")
	public String service5() {
		service5.method();
		return "redirect:/ch13/content";
	}
	
	@GetMapping("/service6")
	public String service6() {
		service6.method();
		return "redirect:/ch13/content";
	}
	
	
	@Value("${fileupload}") private String saveDirPath;
	 
	
	@GetMapping("fileupload")
	public String upload() {
		logger.info("실행");
		logger.info("fileupload: " + saveDirPath);
		service7.method();
		return "redirect:/ch13/content";
	}
	
}
