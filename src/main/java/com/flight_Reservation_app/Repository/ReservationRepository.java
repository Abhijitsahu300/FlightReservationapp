package com.flight_Reservation_app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight_Reservation_app.Entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
