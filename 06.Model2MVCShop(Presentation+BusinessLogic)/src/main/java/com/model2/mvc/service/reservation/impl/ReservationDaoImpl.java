package com.model2.mvc.service.reservation.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Reservation;
import com.model2.mvc.service.reservation.ReservationDao;

@Repository("reservationDaoImpl")
public class ReservationDaoImpl implements ReservationDao {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public int addReservation(Reservation reservation) throws Exception {
		int order = 1+((Integer)sqlSession.selectOne("ReservationMapper.getReservationOrder",reservation.getItemNo())).intValue();
		reservation.setResOrder(order);
		return order;
	}

	@Override
	public int removeReservation(Reservation reservation) throws Exception {
		return sqlSession.delete("ReservationMapper.removeReservation", reservation);
	}

	@Override
	public List<Reservation> getReservationList(Search search, String bookerId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("search", search);
		map.put("bookerId", bookerId);
		return sqlSession.selectList("ReservationMapper.getReservationList", map);
	}

	@Override
	public int getTotalCount(String bookerId) throws Exception {
		return sqlSession.selectOne("ReservationMapper.getTotalCount", bookerId);
	}

}
