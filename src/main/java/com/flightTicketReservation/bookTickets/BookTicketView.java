package com.flightTicketReservation.bookTickets;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.flightTicketReservation.dto.Flight;
import com.flightTicketReservation.dto.Ticket;
import com.flightTicketReservation.dto.User;

public class BookTicketView {

	private BookTicketViewModel bookTicketViewModel;
	private Scanner sc = new Scanner(System.in);
	public BookTicketView(){
		bookTicketViewModel = new BookTicketViewModel(this);
	}
	public void book() {
		System.out.println("From Station:");
		String from = sc.next();
		System.out.println("To Station:");
		String to = sc.next();
		Flight preferedFlight = findFlights(from,to);
		List<User> passengers = getPassengerDetails();
		System.out.println("Total Fare : "+(preferedFlight.getFare()*passengers.size()));
		System.out.println("Pay:\n1-Pay\n2-Cancel\n3-Reschedule");
		int choice = sc.nextInt();
		if(choice == 2) {
			System.out.println("Thank You");
		}else if(choice ==1) {
			bookTicketViewModel.bookTickets(preferedFlight,passengers,from,to);
		}else if(choice ==3) {
			book();
		}
	}
	private List<User> getPassengerDetails() {
		List<User> passengers = new ArrayList<User>();
		System.out.println("Enter Number of Passengers:");
		int noOfPassengers = sc.nextInt();
		sc.nextLine();
		for(int i=1;i<=noOfPassengers;i++) {
			System.out.println("Enter Passenger "+i+" details:");
			System.out.println("Name:");
			String name =sc.nextLine();
			System.out.println("Age:");
			int age = sc.nextInt();
			sc.nextLine();
			System.out.println("Gender:");
			String gender = sc.next();
			User u = new User();
			u.setName(name);
			u.setAge(age);
			u.setGender(gender);
			passengers.add(u);
		}
		return passengers;
	}
	private Flight findFlights(String from, String to) {
		List<Flight> flights = bookTicketViewModel.findFlights(from,to);
		System.out.println("Available Flights");
		for (Flight flight : flights) {
			System.out.println("Flight No:"+flight.getFlightNo()+"||Name:"+flight.getFlightName()+"||Departure Time:"+flight.getDepartureTime()+"||Arrival Time:"+flight.getArrivalTime()+"||Travel Time"+Duration.between(flight.getDepartureTime(), flight.getArrivalTime()).toHours()+"||Fare:"+flight.getFare()+"||Seats:"+flight.getTotalSeats());
		}
		System.out.println("Enter Flight Number:");
		Flight preferedFlight = null;
		do {
			int flightNo = sc.nextInt();
			for (Flight flight : flights) {
				if(flight.getFlightNo()==flightNo) {
					preferedFlight = flight;
				}
			}
			if(preferedFlight!=null) {
				break;
			}
		} while (true);
		return preferedFlight;
	}
	public void booked(Ticket t) {
		System.out.println("Ticket(s) Booked Successfully");
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
}
