package com.flightTicketReservation.viewPassenger;

import java.util.Scanner;

import com.flightTicketReservation.dto.User;

public class ViewPassengerView {

	private ViewPassengerViewModel model;
	public ViewPassengerView() {
		model = new ViewPassengerViewModel(this);
	}
	public void viewPassenger() {
		System.out.println("Enter Passenger Id : ");
		int id =new Scanner(System.in).nextInt();
		User u = model.findPassenger(id);
		System.out.println("Name : "+u.getName()+"||Age : "+u.getAge()+"||Gender : "+u.getGender()+"||Id : "+u.getId()+"||Flight : "+u.getFlight().getFlightNo());
	}
}
