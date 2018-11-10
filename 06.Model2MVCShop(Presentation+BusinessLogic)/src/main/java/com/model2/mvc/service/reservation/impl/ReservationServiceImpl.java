package com.model2.mvc.service.reservation.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Reservation;
import com.model2.mvc.service.reservation.ReservationDao;
import com.model2.mvc.service.reservation.ReservationService;

@Service("reservationServiceImpl")
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	@Qualifier("reservationDaoImpl")
	private ReservationDao reservationDao;
	public void setReservationDao(ReservationDao reservationDao) {
		this.reservationDao=reservationDao;
	}

	@Override
	public int addReservation(Reservation reservation) throws Exception {
		return reservationDao.addReservation(reservation);
	}

	@Override
	public int removeReservation(Reservation reservation) throws Exception {
		return reservationDao.removeReservation(reservation);
	}

	@Override
	public Map<String, Object> getReservationList(Search search, String bookerId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", reservationDao.getReservationList(search, bookerId));
		map.put("totalCount", reservationDao.getTotalCount(bookerId));
		
		return map;
	}

}
