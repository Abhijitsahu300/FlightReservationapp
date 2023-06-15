package com.flight_Reservation_app.Entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Reservation extends AbstractEntity {
	private boolean checkedIn;
	private int numberOfBags;
	
	@OneToOne
	private Passenger passenger;
	
	@OneToOne

	private Flight flight;

	public boolean isCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public int getNumberOFBags() {
		return numberOfBags;
	}

	public void setNumberOFBags(int numberOFBags) {
		this.numberOfBags = numberOFBags;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	
	
	
   
}
