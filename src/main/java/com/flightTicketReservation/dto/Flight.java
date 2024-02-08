package com.flightTicketReservation.dto;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Flight {

	@Id
	private int flightNo ;
	private String flightName;
	private LocalTime departureTime;
	private LocalTime arrivalTime;
	private String routes;
	private int totalSeats;
	private double fare;
	public int getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public LocalTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getRoutes() {
		return routes;
	}
	public void setRoutes(String routes) {
		this.routes = routes;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	
}
