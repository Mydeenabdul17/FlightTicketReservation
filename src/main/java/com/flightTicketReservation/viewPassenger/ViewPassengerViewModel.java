package com.flightTicketReservation.viewPassenger;

import com.flightTicketReservation.dto.User;
import com.flightTicketReservation.repository.FlightTicketRepository;

public class ViewPassengerViewModel {

	private ViewPassengerView passengerView;

	private FlightTicketRepository repository = FlightTicketRepository.getInstance();
	public ViewPassengerViewModel(ViewPassengerView passengerView) {
		super();
		this.passengerView = passengerView;
	}

	public User findPassenger(int id) {
		return repository.findPassenger(id);
	}
	
}
