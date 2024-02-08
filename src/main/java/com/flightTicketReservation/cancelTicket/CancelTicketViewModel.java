package com.flightTicketReservation.cancelTicket;

import com.flightTicketReservation.dto.Ticket;
import com.flightTicketReservation.repository.FlightTicketRepository;

public class CancelTicketViewModel {

	private CancelTicketView cancelTicketView;

	private FlightTicketRepository repository = FlightTicketRepository.getInstance();
	public CancelTicketViewModel(CancelTicketView cancelTicketView) {
		super();
		this.cancelTicketView = cancelTicketView;
	}

	public void cancelTicket(int pnr) {
		Ticket t = repository.getTicket(pnr);
		t.setStatus("Canceled");
		repository.changeStatus(t);
		cancelTicketView.canceled(t.getTotal());
	}
	
}
