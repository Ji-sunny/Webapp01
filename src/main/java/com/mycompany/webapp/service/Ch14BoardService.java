package com.mycompany.webapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.DAO.Ch14BoardDao;
import com.mycompany.webapp.dto.Ch14Pager;
import com.mycompany.webapp.dto.Ch14board;

@Service
public class Ch14BoardService {
private static final Logger logger = LoggerFactory.getLogger(Ch14BoardService.class);
	
	@Resource
	private Ch14BoardDao boardDao;
	
	public List<Ch14board> getBoardList(){
		List<Ch14board> list = boardDao.selectAll();
		return list;
	}
	
	public List<Ch14board> getBoardList(Ch14Pager pager){
		List<Ch14board> list = boardDao.selectByPage(pager);
		return list;
	}
	
	public void saveBoard(Ch14board board) {
		boardDao.insert(board);
	}
	
	public int getTotalRows() {
		int totalRows = boardDao.countAll();
		return totalRows;
	}

	public Ch14board getBoard(int bno) {
		Ch14board board = boardDao.selectByPK(bno);
		return board;
	}

	public int updateBoard(Ch14board board) {
		int rows = boardDao.update(board);
		return rows;
		
	}

	public int deleteBoard(int bno) {
		int rows = boardDao.delete(bno);
		return rows;
	}

	public void addHitcount(int bno) {
		boardDao.updateHitcount(bno);
		
	}
}
