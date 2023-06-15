package com.flight_Reservation_app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flight_Reservation_app.Entity.Reservation;
import com.flight_Reservation_app.dto.ReservationRequest;
import com.flight_Reservation_app.service.ReservationService;
import com.flight_Reservation_app.utility.EmailUtil;
import com.flight_Reservation_app.utility.PdfGenerator;


@Controller
public class ReservationController {
	

	public static String filePath="C:\\Springboot Project\\flight_Reservation_app\\pdfDocs\\reservation";
	@Autowired
	private EmailUtil emailUtil;
	
	
	@Autowired
	private ReservationService reservationService;

	@RequestMapping("/confirmReservation")  // dto class is created and data transfer is done here
	public String confirmReservation(ReservationRequest request,ModelMap model) {
		Reservation reservation = reservationService.bookFlight(request);
		
		
		
		PdfGenerator pdf = new PdfGenerator();
		pdf.generatePDF(filePath+reservation.getId()+".pdf", reservation.getPassenger().getFirstName(), reservation.getPassenger().getEmail(), reservation.getPassenger().getPhone(), reservation.getFlight().getOperatingAirlines(), reservation.getFlight().getDateOfDeparture(), reservation.getFlight().getDepartureCity(), reservation.getFlight().getArrivalCity());
		model.addAttribute("reservationId", reservation.getId());
		
		EmailUtil util = new EmailUtil();
		String attachment = filePath+reservation.getId()+".pdf";
		emailUtil.sendItinerary(request.getEmail(), attachment);
		
		
		
		return"confirmReservation";
		
	}
	
	
	
}
