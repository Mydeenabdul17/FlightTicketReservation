package com.flightTicketReservation.bookTickets;

import java.util.List;

import com.flightTicketReservation.dto.Flight;
import com.flightTicketReservation.dto.Ticket;
import com.flightTicketReservation.dto.User;
import com.flightTicketReservation.repository.FlightTicketRepository;

public class BookTicketViewModel {

	private BookTicketView bookTicketView;

	private FlightTicketRepository repository = FlightTicketRepository.getInstance();
	public BookTicketViewModel(BookTicketView bookTicketView) {
		this.bookTicketView = bookTicketView;
	}

	public List<Flight> findFlights(String from, String to) {
		List<Flight> flights = repository.getFlights(from,to);
		return flights;
	}

	public void bookTickets(Flight preferedFlight, List<User> passengers, String from, String to) {
		Ticket t = new Ticket();
		for (User user : passengers) {
			user.setFlight(preferedFlight);
		}
		t.setFlight(preferedFlight);
		t.setPassengers(passengers);
		t.setStatus("CNF");
		t.setTotal(preferedFlight.getFare()*passengers.size());
		t.setFrom(from);
		t.setTo(to);
		repository.bookTicket(t);
		bookTicketView.booked(t);
	}
	
}
