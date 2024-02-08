package com.flightTicketReservation.viewTicket;

import java.util.List;

import com.flightTicketReservation.dto.Ticket;
import com.flightTicketReservation.repository.FlightTicketRepository;

public class ViewTicketViewModel {

	private ViewTicketView ticketView;

	private FlightTicketRepository repository = FlightTicketRepository.getInstance();
	public ViewTicketViewModel(ViewTicketView ticketView) {
		super();
		this.ticketView = ticketView;
	}
	public Ticket getTicket(int pnr) {
		Ticket t = repository.getTicket(pnr);
		return t;
	}
	public List<Ticket> getTickets() {
		
		return repository.getAllTickets();
	}
	
}
