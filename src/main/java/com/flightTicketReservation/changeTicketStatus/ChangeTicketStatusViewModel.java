package com.flightTicketReservation.changeTicketStatus;

import com.flightTicketReservation.dto.Ticket;
import com.flightTicketReservation.repository.FlightTicketRepository;

public class ChangeTicketStatusViewModel {

	private ChangeTicketStatusView statusView;

	private FlightTicketRepository repository = FlightTicketRepository.getInstance();
	public ChangeTicketStatusViewModel(ChangeTicketStatusView statusView) {
		super();
		this.statusView = statusView;
	}

	public Ticket findTicket(int pnr) {
		return repository.getTicket(pnr);
	}

	public void changeStatus(Ticket t) {
		repository.changeStatus(t);
	}
	
}
