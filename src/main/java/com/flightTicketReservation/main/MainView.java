package com.flightTicketReservation.main;

import java.util.Scanner;

import com.flightTicketReservation.addFlights.AddFlightView;
import com.flightTicketReservation.bookTickets.BookTicketView;
import com.flightTicketReservation.cancelTicket.CancelTicketView;
import com.flightTicketReservation.changeTicketStatus.ChangeTicketStatusView;
import com.flightTicketReservation.viewPassenger.ViewPassengerView;
import com.flightTicketReservation.viewTicket.ViewTicketView;

public class MainView {

	private MainViewModel viewModel;
	Scanner sc = new Scanner(System.in);

	public MainView() {
		viewModel = new MainViewModel(this);

	}

	public void init() {
		/*
		 * Enter your option : (1-Booking,2-Get PNR status,3-Booked tickets 4-Cancel
		 * Tickets,5-Search passenger,6- Change ticket status of a passenger,7-List
		 * flight routes,8-Add flight routes)
		 */
		System.out.println("Welcome To Indian Railway");
		do {
			System.out.println("Enter the option\n1.Add Flight\n2.Open Application\n3.Exit");
			int choice = sc.nextInt();
			if (choice == 1) {
				new AddFlightView().addFlight();
			} else if (choice == 2) {
				start();
			} else if (choice == 3) {
				break;
			}
		} while (true);

	}

	public void start() {
		outer:do {
			System.out.println("Welcome to IRCTC");
			System.out.println("Enter the option");
			System.out.println(
					"1-Booking\n2-Get PNR status\n3-Booked tickets\n 4-Cancel Tickets\n5-Search passenger\n6- Change ticket status of a passenger\n7-Exit");
			switch (sc.nextInt()) {
			case 1: {
				new BookTicketView().book();
				break;
			}
			case 2: {
				new ViewTicketView().viewByPNR();
				break;
			}
			case 3: {
				new ViewTicketView().viewTickets();
				break;
			}
			case 4: {
				System.out.println("Enter PNR Number : ");
				int pnr = sc.nextInt();
				new CancelTicketView().cancelTicket(pnr);
				break;
			}
			case 5: {
				new ViewPassengerView().viewPassenger();
				break;
			}
			case 6: {
				new ChangeTicketStatusView().changeStatus();
				break;
			}
			case 7: {

				break outer;
			}
			default:
				break;
			}
		} while (true);
	}
}
