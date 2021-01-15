package com.mycompany.webapp.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.webapp.dto.Ch07Board;
import com.mycompany.webapp.dto.Ch08Board;


@Controller
@RequestMapping("/ch08")
public class Ch08Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch08Controller.class);
	
	@GetMapping("/content")
	public String content() {
		logger.info("실행");
		return "ch08/content";
	}

	@GetMapping("/method1")
	public String method1(HttpSession session) {
		session.setAttribute("name", "스프링");
		session.setAttribute("age", 20);
		session.setAttribute("job", "AI");
		return "ch08/el";
	}
	
	@GetMapping("/method2")
	public String method2(HttpSession session) {
		
		Ch07Board board = new Ch07Board();
		board.setNo(1);
		board.setTitle("마스크에 가려진 너");
		board.setContent("내가 너랑 결혼이라니!");
		board.setWriter("김지애작가님");
		board.setDate(new Date());
		session.setAttribute("BestSeller", board);
		//Best Seller에 board를 저장
		return "ch08/el";
	}
	
	@GetMapping("/method3")
	public String method3(HttpSession session) {
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
		session.setAttribute("boardList", list);
		return "ch08/el";
	}
	
	@PostMapping("/login")
	public String login(String uid, String upw, HttpSession session) {
		if(uid.equals("admin")&& upw.equals("123456")) {
			session.setAttribute("loginStatus", uid);
		}
		
		return "redirect:/ch08/content";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//개별적으로 데이터를 삭제
		//session.removeAttribute("loginStatus");
		//session에 저장된 데이터 모두 삭제
		session.invalidate();
		return "redirect:/ch08/content";
	}
	
	@PostMapping("/boardWrite")
	public String boardWirte(Ch08Board board, HttpSession session) {
		String uid = (String) session.getAttribute("loginStatus");
		if (uid != null) {
			board.setWriter(uid);
			logger.info("게시물을 성공적으로 저장함");
			logger.info(board.getWriter());
			logger.info(board.getTitle());
			logger.info(board.getContent());
			session.removeAttribute("board");
		} else {
			logger.info("로그인을 먼저 해주세요");
		}
		return "redirect:/ch08/content";
	}
	
	@GetMapping("/board")
	public String board(HttpSession session) {
		session.setAttribute("board","board");
		
		return "redirect:/ch08/content";
	}
	
	
}
