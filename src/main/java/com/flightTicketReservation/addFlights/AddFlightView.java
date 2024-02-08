package com.flightTicketReservation.addFlights;

import java.time.LocalTime;
import java.util.Scanner;

import com.flightTicketReservation.dto.Flight;

public class AddFlightView {

	private AddFlightViewModel addFlightViewModel;
	private Scanner sc = new Scanner(System.in);
	public AddFlightView() {
		addFlightViewModel = new AddFlightViewModel(this);
	}
	public void addFlight() {
		
		System.out.println("Enter Flight Number:");
		int flightNo = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Flight Name:");
		String flightName = sc.nextLine();
		System.out.println("Enter Flight Departure time (HH:mm:ss):");
		String departure = sc.nextLine();
		System.out.println("Enter Flight Arrival time (HH:mm:ss):");
		String arrival = sc.nextLine();
		System.out.println("Enter Total Seat Count:");
		int seats = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Routes in , seperated Single String:");
		String routes = sc.nextLine();
		System.out.println("Emter the Ticket Fare:");
		int fare = sc.nextInt();
		Flight flight = new Flight();
		flight.setFlightNo(flightNo);
		flight.setFlightName(flightName);
		flight.setDepartureTime(LocalTime.parse(departure));
		flight.setArrivalTime(LocalTime.parse(arrival));
		flight.setTotalSeats(seats);
		flight.setRoutes(routes);
		flight.setFare(fare);
		addFlightViewModel.addFlight(flight);
	}
	public void added() {
		System.out.println("Flight Added\nTo Add More Flight Enter y/n");
		if(sc.next().charAt(0)=='y') {
			addFlight();
		}
	}
}
