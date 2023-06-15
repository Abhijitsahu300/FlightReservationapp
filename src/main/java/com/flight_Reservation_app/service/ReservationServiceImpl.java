package com.flight_Reservation_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight_Reservation_app.Entity.Flight;
import com.flight_Reservation_app.Entity.Passenger;
import com.flight_Reservation_app.Entity.Reservation;
import com.flight_Reservation_app.Repository.FlightRepository;
import com.flight_Reservation_app.Repository.PassengerRepository;
import com.flight_Reservation_app.Repository.ReservationRepository;
import com.flight_Reservation_app.dto.ReservationRequest;

import com.flight_Reservation_app.utility.PdfGenerator;


@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private PassengerRepository passengerRepo;
	
	@Autowired
	private FlightRepository flightRepo; 
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
//	    String filePath="C:\\tickets\\booking\\";
		
//		String firstName = request.getFirstName();
//		String lastName = request.getLastName();
//		String middleName = request.getMiddleName();
//		String email = request.getEmail();
//		long phone = request.getPhone();
		
		
		Passenger passenger =new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setLastName( request.getLastName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone( request.getPhone());
		passengerRepo.save(passenger);
		
		long flightId = request.getFlightId();
	    Optional<Flight> findById = flightRepo.findById(flightId);
	    Flight flight = findById.get();
	    
	    
	    Reservation reservation= new Reservation();
	    reservation.setFlight(flight);
	    reservation.setPassenger(passenger);
	    reservation.setCheckedIn(false);
	    reservation.setNumberOFBags(0);
	    reservationRepo.save(reservation);
	    
//        PdfGenerator pdf=new PdfGenerator();
//		pdf.generatePDF(filePath+reservation.getId()+".pdf",request.getFirstName(),request.getEmail() ,  request.getPhone(),flight.getOperatingAirlines() ,flight.getDateOfDeparture(),flight.getEstimatedDepartureTime(),flight.getDepartureCity(), flight.getArrivalCity());
//	    
		return reservation;
	}
   
}
