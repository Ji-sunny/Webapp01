package com.mycompany.webapp.controller;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.webapp.dto.Ch14Employee;
import com.mycompany.webapp.dto.Ch14Pager;
import com.mycompany.webapp.dto.Ch14board;
import com.mycompany.webapp.service.Ch14BoardService;
import com.mycompany.webapp.service.Ch14EmployeeService;

@Controller
@RequestMapping("/ch14")
public class Ch14Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch14Controller.class);
	
	@GetMapping(value = "/content")
	public String Content() {
		return "ch14/content";
	}
	
	//root에 ch14_datasource가 있음 구현객체 있음
	@Resource
	private DataSource dataSource;
	
	@GetMapping(value = "/conntest")
	public String Conntest(Model model) {
		//connection pool에서 connection 대여
		try {
			Connection conn = dataSource.getConnection();
			model.addAttribute("result", "연결성공");
			
			conn.close();
			//connection 반납
		} catch (SQLException e) {
			model.addAttribute("result", "연결실패");
			e.printStackTrace();
		} 
		return "ch14/conntest";
	}
	
	@GetMapping(value = "/jsonresponse1")
	public void jsonresponse1(HttpServletResponse response) throws Exception {
		response.setContentType("application/json; charset=UTF-8");
		//데이터 보내기
		PrintWriter pw = response.getWriter();
		//http의 본문에 실려서 감
		/* pw.println("{\"name\": \"홍길동\", \"age\": 30}"); */
		//하나의 객체를 표현
		/*
		 * pw.println("{"); pw.println("\"name\": \"홍길동\",");
		 * pw.println("\"age\": 30 ,"); //하나의 속성에 값으로 배열을 보내줌
		 * pw.println("\"hobby\": [\"영화\", \"여행\", \"수영\"],");
		 * pw.println("\"car\":{\"kind\": \"그랜저\", \"color\": \"흰색\"}");
		 * pw.println("}");
		 */
		//{}를 만든다. JSONObject라는 뜻
		JSONObject root = new JSONObject();
		root.put("name", "홍길동");
		root.put("age", 30);
		
		//car에 대한 object를 만들고, 그 car를 넣는다.
		JSONObject car = new JSONObject();
		car.put("kind", "그렌저");
		car.put("color", "흰색");
		root.put("car", car);
		
		JSONArray hobby = new JSONArray();
		hobby.put("영화");
		hobby.put("여행");
		hobby.put("수영");
		root.put("hobby", hobby);
		
		//모든 문자열 얻기
		String json = root.toString();
		pw.println(json);
		pw.flush();
		pw.close();
	}
	
	@GetMapping(value = "/jsonresponse2")
	public void jsonresponse2(HttpServletResponse response) throws Exception {
		response.setContentType("application/json; charset=UTF-8");
		//데이터 보내기
		PrintWriter pw = response.getWriter();
		//http의 본문에 실려서 감
//		pw.println("[");
//		pw.println("{\"bno\":1, \"btitle\":\"제목1\", \"bwriter\":\"글쓴이1\"},");
//		pw.println("{\"bno\":2, \"btitle\":\"제목2\", \"bwriter\":\"글쓴이2\"},");
//		pw.println("{\"bno\":3, \"btitle\":\"제목3\", \"bwriter\":\"글쓴이3\"}");
//		pw.println("]");
		JSONArray root = new JSONArray();
		for(int i=1; i<=3; i++) {
			JSONObject board = new JSONObject();
			board.put("bno", i);
			board.put("btitle", "제목" + i);
			board.put("bwriter", "작가" + i);
			root.put(board); //배열 추가
		}
		String json = root.toString();
		pw.println(json);
		pw.flush();
		pw.close();
	}
	
	@Resource private Ch14EmployeeService employeeservice;
	
	@GetMapping(value = "/employee")
	public String employee(int employee_id) {
		Ch14Employee emp = employeeservice.getEmployee(employee_id);
		logger.info("employee_id: " + emp.getEmployee_id());
		logger.info("first_name: " + emp.getFirst_name());
		logger.info("last_name: " + emp.getLast_name());
		System.out.println(emp.toString());
		return "ch14/content";
		
	}
	
	@GetMapping(value = "/employee2")
	public void employee2(int employee_id, HttpServletResponse response) throws Exception {
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		Ch14Employee emp = employeeservice.getEmployee(employee_id);
		JSONObject root = new JSONObject();
		root.put("employee_id", emp.getEmployee_id());
		root.put("first_name", emp.getFirst_name());
		root.put("last_name", emp.getLast_name());
		String json = root.toString();
		pw.println(json);
		pw.flush();
		pw.close();
	}
	
	@Resource
	private Ch14BoardService boardservice;
	
	@GetMapping(value = "/boardlist")
	public String boardlist(Model model) {
		List<Ch14board> list = boardservice.getBoardList();
		model.addAttribute("list", list);
		return "ch14/boardlist";
	}
	
	@GetMapping(value = "/boardsave")
	public String boardsave() {
//		for(int i=1; i<=100; i++) {
//			Ch14board board = new Ch14board();
//			board.setBtitle("제목" + i);
//			board.setBcontent("내용" + i);
//			board.setBwriter("winter");
//			boardservice.saveBoard(board);
//		}
		return "redirect:/ch14/boardlist";
	}
	
	@GetMapping(value = "/boardlist2")
	public String boardlist2(@RequestParam(defaultValue="1")int pageNo, Model model) {
		int totalRows = boardservice.getTotalRows();
		Ch14Pager pager = new Ch14Pager(10, 5, totalRows, pageNo);
		List<Ch14board> list = boardservice.getBoardList(pager);
		model.addAttribute("list", list);
		return "ch14/boardlist";
	}
	
}
