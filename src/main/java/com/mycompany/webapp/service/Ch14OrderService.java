package com.mycompany.webapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.webapp.DAO.Ch14OrderDao;
import com.mycompany.webapp.dto.Ch14Order;
import com.mycompany.webapp.dto.Ch14OrderItems;

@Service
public class Ch14OrderService {
private static final Logger logger = LoggerFactory.getLogger(Ch14OrderService.class);
	
	
	@Resource
	Ch14OrderDao orderdao;

		
	// insert가 총 3개가 들어가는데 3개중에 하나라도 안되면 안됨
	@Transactional
	/* list는 카트에서 만들어서 제공 */
	public void order(Ch14Order order, List<Ch14OrderItems> orderitems) {
		//orders table의 주분 정보 저장
		orderdao.insertOrder(order);
		//생성된 주문 번호는?
		int ono = order.getOno();
		//orderitems 테이블에 주문 상품 정보 저장
		for(Ch14OrderItems oi : orderitems) {
			oi.setOno(ono);
			orderdao.insertOrderItem(oi);
		}
	}
}
