package com.model2.mvc.service.reservation;

import java.util.Map;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Reservation;

public interface ReservationService {
	
	public int addReservation(Reservation reservation) throws Exception;
	
	public int removeReservation(Reservation reservation) throws Exception;
	
	public Map<String,Object> getReservationList(Search search, String bookerId) throws Exception;
	
}
