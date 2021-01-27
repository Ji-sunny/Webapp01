package com.mycompany.webapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.channels.SeekableByteChannel;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.webapp.dto.Ch14Employee;
import com.mycompany.webapp.dto.Ch14Member;
import com.mycompany.webapp.dto.Ch14Order;
import com.mycompany.webapp.dto.Ch14OrderItems;
import com.mycompany.webapp.dto.Ch14Pager;
import com.mycompany.webapp.dto.Ch14board;
import com.mycompany.webapp.service.Ch14BoardService;
import com.mycompany.webapp.service.Ch14EmployeeService;
import com.mycompany.webapp.service.Ch14MemberService;
import com.mycompany.webapp.service.Ch14OrderService;

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
		Ch14Pager pager = new Ch14Pager(6, 5, totalRows, pageNo);
		List<Ch14board> list = boardservice.getBoardList(pager);
		model.addAttribute("list", list);
		model.addAttribute("pager",pager);
		return "ch14/boardlist";
	}
	
	@GetMapping(value = "/boardwrite")
	public String boardWriteFrom() {
		return "ch14/boardwrite";
	}
	

	@PostMapping(value = "/boardwrite")
	public String boardwrite(Ch14board board, HttpSession session) throws Exception{
		System.out.println(board.toString());
		String mid = (String) session.getAttribute("sessionMid");
		board.setBwriter(mid);
		MultipartFile mf = board.getBattach();
		if(!mf.isEmpty()) {
			board.setBattachoname((mf.getOriginalFilename()));
			String saveName = new Date().getTime() + "-" +mf.getOriginalFilename();
			board.setBattachsname(saveName);
			board.setBattachtype(mf.getContentType());
			//파일 저장
			File saveFile = new File("D:/MyWorkPlace/uploadfiles/boards/" + saveName);
			mf.transferTo(saveFile);
		}
		
		boardservice.saveBoard(board);
		
		return "redirect:/ch14/boardlist2";
	}
	
	@GetMapping(value = "/join")
	public String joinForm() {
		return "ch14/join";
	}
	
	@Resource
	private Ch14MemberService memberService;
	
	@PostMapping(value = "/join")
	public String join(Ch14Member member) throws Exception {
		//파일 정보 얻기
		MultipartFile mf = member.getMphoto();
		if(!mf.isEmpty()) {
			member.setMphotooname(mf.getOriginalFilename());
			String saveName = new Date().getTime() + "-" +mf.getOriginalFilename();
			member.setMphotosname(saveName);
			member.setMphototype(mf.getContentType());
			//파일 저장
			File saveFile = new File("D:/MyWorkPlace/uploadfiles/members/" + saveName);
			mf.transferTo(saveFile);
		}
		//DB에 저장
		
		memberService.join(member);
		return "redirect:/ch14/boardlist2";
	}
	
	@GetMapping(value = "/mphoto")
	public void mphoto(String mid, HttpSession sesson, HttpServletResponse response) throws Exception {
		if(mid == null) {
			mid =(String) sesson.getAttribute("sessionMid");
		}
		
		
		Ch14Member member = memberService.getMember(mid);
		String filePath = null;
		
		if(member.getMphotosname() != null) {
			String mphotosname = member.getMphotosname();
			filePath = "D:/MyWorkPlace/uploadfiles/members/" + mphotosname;
			
			response.setContentType(member.getMphototype());
			
			String mphotooname = member.getMphotooname();
			mphotooname = new String(mphotooname.getBytes("UTF-8"), "ISO-8859-1");
			response.setHeader("Content-Disposition", "attachment; filename=\""+ mphotooname +"\"");
		} else {
			filePath = "D:/MyWorkPlace/uploadfiles/members/defaultphoto.jpg";

			response.setContentType("image/jpeg");
		}
		OutputStream os = response.getOutputStream();
		InputStream is = new FileInputStream(filePath);
		FileCopyUtils.copy(is,os);
		os.flush();
		os.close();
		is.close();
		
	}
	
	@GetMapping(value = "/login")
	public String loginForm() {
		return "ch14/login";
	}
	
	//success, wrongMid, wrongPassword
	@PostMapping(value = "/login")
	public void login(Ch14Member member, HttpServletResponse reponse, HttpSession session) throws Exception {
		String result = memberService.login(member);
		if(result.equals("success")) session.setAttribute("sessionMid", member.getMid());
		
		reponse.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = reponse.getWriter();
		
		
		//result: ???
		JSONObject root = new JSONObject();
		root.put("result", result);
		pw.println(root.toString());
		
		pw.flush();
		pw.close();
	}
	
	@GetMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/ch14/boardlist2";
	}
	
	@GetMapping(value = "/boardread")
	public String boardread(int bno, Model model) {
		boardservice.addHitcount(bno);
		Ch14board board = boardservice.getBoard(bno);
		model.addAttribute("board", board);
		return "ch14/boardread";
	}
	
	@GetMapping(value = "/boardupdate")
	public String boardupdateForm(int bno, Model model) {
		Ch14board board = boardservice.getBoard(bno);
		model.addAttribute("board", board);
		return "ch14/boardupdate";
	}
	
	@PostMapping(value = "/boardupdate")
	public String boardupdate(Ch14board board) {
		int num = boardservice.updateBoard(board);
		System.out.println(num);
		return "redirect:/ch14/boardlist2";
	}
	
	@GetMapping(value = "/boarddelete")
	public String boarddeleteForm(int bno) {
		int num = boardservice.deleteBoard(bno);
		System.out.println(num);
		return "redirect:/ch14/boardlist2";
	}
	
	@GetMapping(value = "/battach")
	public void battach(int bno, HttpSession sesson, HttpServletResponse response) throws Exception {
	
		Ch14board board = boardservice.getBoard(bno);
		String filePath = null;
		

		String battachsname = board.getBattachsname();
		filePath = "D:/MyWorkPlace/uploadfiles/boards/" + battachsname;
		
		response.setContentType(board.getBattachtype());
		
		String oname = board.getBattachoname();
		oname = new String(oname.getBytes("UTF-8"), "ISO-8859-1");
		response.setHeader("Content-Disposition", "attachment; filename=\""+ oname +"\"");

		OutputStream os = response.getOutputStream();
		InputStream is = new FileInputStream(filePath);
		FileCopyUtils.copy(is,os);
		os.flush();
		os.close();
		is.close();
		
	}
	
	@Resource
	private Ch14OrderService orderSerive;
	
	@GetMapping(value = "/order")
	public String order() {
		//주문 정보 얻기 > brower에서 받기
		Ch14Order order = new Ch14Order();
		order.setMid("spring");
		order.setAddress("우리집으로 가쟈");
		//주문 상품 정보 얻기 >> 장바구니에서
		
		List<Ch14OrderItems> orderitems = new ArrayList<>();
		Ch14OrderItems oi1 = new Ch14OrderItems();
		oi1.setPid("다이아");
		oi1.setAmount(10);
		orderitems.add(oi1);
		
		Ch14OrderItems oi2 = new Ch14OrderItems();
		oi2.setPid("롯데타워");
		oi2.setAmount(1);
		orderitems.add(oi2);
		
		//주문처리
		orderSerive.order(order, orderitems);
		
		return "ch14/content";
	}
	
}
