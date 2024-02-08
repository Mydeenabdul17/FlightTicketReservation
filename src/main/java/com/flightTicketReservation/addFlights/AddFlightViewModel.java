package com.flightTicketReservation.addFlights;

import com.flightTicketReservation.dto.Flight;
import com.flightTicketReservation.repository.FlightTicketRepository;

public class AddFlightViewModel {

	private AddFlightView addFlightView;

	private FlightTicketRepository repository = FlightTicketRepository.getInstance();
	public AddFlightViewModel(AddFlightView addFlightView) {
		this.addFlightView = addFlightView;
	}

	public void addFlight(Flight flight) {
		repository.addFlight(flight);
		addFlightView.added();
	}
	
}
