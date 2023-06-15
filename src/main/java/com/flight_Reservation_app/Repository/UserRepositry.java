package com.flight_Reservation_app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight_Reservation_app.Entity.User;

public interface UserRepositry extends JpaRepository<User, Long> {

	User findByEmail(String emailId);
	
	

}
