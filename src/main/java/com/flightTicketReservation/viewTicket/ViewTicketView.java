package com.flightTicketReservation.viewTicket;

import java.util.List;
import java.util.Scanner;

import com.flightTicketReservation.dto.Flight;
import com.flightTicketReservation.dto.Ticket;
import com.flightTicketReservation.dto.User;

public class ViewTicketView {

	private ViewTicketViewModel model;
	private Scanner sc = new Scanner(System.in);
	public ViewTicketView() {
		model = new ViewTicketViewModel(this);
	}
	public void viewByPNR() {
		System.out.println("Enter PNR Number : ");
		int pnr = sc.nextInt();
		Ticket t = model.getTicket(pnr);
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
			i++;
		}
	}
	public void viewTickets() {
		List<Ticket> tickets = model.getTickets();
		System.out.println("Total Tickets Booked : "+tickets.size());
		for (Ticket t : tickets) {
			System.out.println("Ticket Details");
			System.out.println("Flight Details");
			System.out.println("------------------");
//			Flight f = t.getFlight();
			Flight f = t.getPassengers().get(0).getFlight();
			System.out.println("Flight Number : "+f.getFlightNo()+"||Flight Name : "+f.getFlightName()+"||Departure Time : "+f.getDepartureTime()+"||Arrival Time : "+f.getArrivalTime()+"||From : "+t.getFrom()+"||To : "+t.getTo()+"||PNR No : "+t.getPnrNo()+"||Total Fare : "+t.getTotal());
			System.out.println("Passenger Details");
			System.out.println("------------------");
			int i=1;
			for(User u : t.getPassengers()) {
				System.out.println(i+". Name : "+u.getName()+"||Age : "+u.getAge()+"||Gender : "+u.getGender()+"||Id : "+u.getId());
				i++;
			}
		}
	}
}
