package com.flightTicketReservation.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pnrNo;
	private String status;
	@OneToOne
	@JoinColumn
	private Flight flight;
	@OneToMany(fetch = FetchType.EAGER)
	private List<User> passengers;
	private String from;
	private String to;
	private double total;
	public int getPnrNo() {
		return pnrNo;
	}
	public void setPnrNo(int pnrNo) {
		this.pnrNo = pnrNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public List<User> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<User> passengers) {
		this.passengers = passengers;
	}
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
