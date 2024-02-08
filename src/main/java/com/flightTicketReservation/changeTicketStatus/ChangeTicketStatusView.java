package com.flightTicketReservation.changeTicketStatus;

import java.util.Scanner;

import com.flightTicketReservation.dto.Flight;
import com.flightTicketReservation.dto.Ticket;
import com.flightTicketReservation.dto.User;

public class ChangeTicketStatusView {

	private ChangeTicketStatusViewModel model;
	private Scanner sc = new Scanner(System.in);
	public ChangeTicketStatusView() {
		model = new ChangeTicketStatusViewModel(this);
	}
	public void changeStatus() {
		System.out.println("Enter PNR Number : ");
		int pnr = sc.nextInt();
		Ticket t = model.findTicket(pnr);
		System.out.println("Enter Ticket status :\n(1.CNF 2.CANCEL)");
		int status = sc.nextInt();
		if(status==1) {
			t.setStatus("CNF");
		}else if(status == 2) {
			t.setStatus("Cancel");
		}
		model.changeStatus(t);
		System.out.println("Ticket Status Updated");
		System.out.println("Ticket Details");
		System.out.println("Flight Details");
		System.out.println("------------------");
//		Flight f = t.getFlight();
		Flight f = t.getPassengers().get(0).getFlight();
		System.out.println("Flight Number : "+f.getFlightNo()+"||Flight Name : "+f.getFlightName()+"||Departure Time : "+f.getDepartureTime()+"||Arrival Time : "+f.getArrivalTime()+"||From : "+t.getFrom()+"||To : "+t.getTo()+"||PNR No : "+t.getPnrNo()+"||Total Fare : "+t.getTotal());
		System.out.println("Passenger Details");
		System.out.println("------------------");
		int i=1;
		for(User u : t.getPassengers()) {
			System.out.println(i+". Name : "+u.getName()+"||Age : "+u.getAge()+"||Gender : "+u.getGender()+"||Id : "+u.getId());
		}
	}
}
