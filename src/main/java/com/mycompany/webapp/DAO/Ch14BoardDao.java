package com.mycompany.webapp.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mycompany.webapp.dto.Ch14Pager;
import com.mycompany.webapp.dto.Ch14board;

@Repository
public class Ch14BoardDao {
	private static final Logger logger = LoggerFactory.getLogger(Ch14BoardDao.class);
	
	//Field datasource에서 가져오는거지
	@Resource
	private SqlSessionTemplate sst;
	
	//Method
	//return이 되는 게 자바 객체로 가져옴 그래서 field를 갖는 클래스가 return자리에 들어감
	public List<Ch14board> selectAll() {
		List<Ch14board> list = sst.selectList("boards.selectAll");
		return list;
	}
	
	/* insert나 update ...등등에서 된 행수를 보여줌 */
	public int insert(Ch14board board) {
		int rows = sst.insert("boards.insert", board);
		return rows;
	}
	
	public int countAll() {
		int count = sst.selectOne("boards.countAll");
		return count;
	}

	public List<Ch14board> selectByPage(Ch14Pager pager) {
		List<Ch14board> list = sst.selectList("boards.selectByPage", pager);
		return list;
	}

	public Ch14board selectByPK(int bno) {
		Ch14board board = sst.selectOne("boards.selectByPK", bno);
		return board;
	}

	public int update(Ch14board board) {
		int rows = sst.update("boards.update", board);
		return rows;
	}

	public int delete(int bno) {
		int rows = sst.delete("boards.delete", bno);
		return rows;
	}

	public void updateHitcount(int bno) {
		sst.update("boards.updatehitcount", bno);
		
	}
}
