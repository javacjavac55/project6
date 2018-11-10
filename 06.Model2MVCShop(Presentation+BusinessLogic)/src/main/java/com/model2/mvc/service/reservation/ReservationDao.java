package com.model2.mvc.service.reservation;

import java.util.List;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Reservation;

public interface ReservationDao {

	public int addReservation(Reservation reservation) throws Exception;
	
	public int removeReservation(Reservation reservation) throws Exception;
	
	public List<Reservation> getReservationList(Search search, String bookerId) throws Exception;
	
	public int getTotalCount (String bookerId) throws Exception;
	
}
