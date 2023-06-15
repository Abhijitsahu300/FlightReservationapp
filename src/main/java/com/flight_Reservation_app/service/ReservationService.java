package com.flight_Reservation_app.service;

import com.flight_Reservation_app.Entity.Reservation;
import com.flight_Reservation_app.dto.ReservationRequest;

public interface ReservationService {

	
	Reservation bookFlight(ReservationRequest request);
	
}
