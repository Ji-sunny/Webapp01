package com.mycompany.webapp.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.webapp.dto.Ch07Board;

@Controller
@RequestMapping("/ch07")
public class Ch07Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch07Controller.class);
	
	@GetMapping("/content")
	public String content() {
		logger.info("실행");
		return "ch07/content";
	}

	@GetMapping("/method1")
	public String method1(Model model) {
		model.addAttribute("name", "스프링");
		model.addAttribute("age", 20);
		model.addAttribute("job", "AI");
		return "ch07/el";
	}
	
	@GetMapping("/method2")
	public String method2(Model model) {
		
		Ch07Board board = new Ch07Board();
		board.setNo(1);
		board.setTitle("마스크에 가려진 너");
		board.setContent("내가 너랑 결혼이라니!");
		board.setWriter("김지애작가님");
		board.setDate(new Date());
		model.addAttribute("BestSeller", board);
		//Best Seller에 board를 저장
		return "ch07/el";
	}
	
	@GetMapping("/method3")
	public String method3(Model model) {
		List <Ch07Board> list = new ArrayList<>();
		for (int i=1; i<=10; i++) {
			Ch07Board board = new Ch07Board();
			board.setNo(i);
			board.setTitle("title" + i);
			board.setContent("content" + i);
			board.setWriter("writer" + i);
			board.setDate(new Date());
			list.add(board);
		};
		model.addAttribute("boardList", list);
		return "ch07/el";
	}
	
	
}
