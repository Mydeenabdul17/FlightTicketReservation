package com.flightTicketReservation.cancelTicket;

import java.util.Scanner;

public class CancelTicketView {

	private CancelTicketViewModel cancelTicketViewModel;
	public CancelTicketView() {
		cancelTicketViewModel = new CancelTicketViewModel(this);
	}
	public void cancelTicket(int pnr) {
		System.out.println("Do You Want To Cancel The Ticket?y/n");
		if(new Scanner(System.in).next().charAt(0)=='y')
		cancelTicketViewModel.cancelTicket(pnr);
	}
	public void canceled(double total) {
		System.out.println("Ticket Cancelled Successfully.Your refund"+total+" will be processed soon");
	}
}
