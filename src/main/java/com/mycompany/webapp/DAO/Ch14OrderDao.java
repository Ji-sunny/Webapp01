package com.mycompany.webapp.DAO;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mycompany.webapp.dto.Ch14Order;
import com.mycompany.webapp.dto.Ch14OrderItems;
import com.mycompany.webapp.dto.Ch14Pager;
import com.mycompany.webapp.dto.Ch14board;

@Repository
public class Ch14OrderDao {
	private static final Logger logger = LoggerFactory.getLogger(Ch14OrderDao.class);
	
	//Field datasource에서 가져오는거지
	@Resource
	private SqlSessionTemplate sst;
	
	public int insertOrder(Ch14Order order) {
		int rows = sst.insert("orders.orderinsert", order);
		return rows;
	}
	
	public int insertOrderItem(Ch14OrderItems orderitem) {
		int rows = sst.insert("orders.orderiteminsert", orderitem);
		return rows;
	}
}
