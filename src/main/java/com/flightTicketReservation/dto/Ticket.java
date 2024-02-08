package com.flightTicketReservation.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pnrNo;
	/*@Column(name = "`from`")
private String from;
*/
	@Column(name = "`status`")
	private String status;
	@Column(name = "`from`")
	private String from;
	@Column(name = "`to`")
	private String to;
	@Column(name = "`total`")
	private double total;
//	@OneToOne
//	@JoinColumn
//	private Flight flight;
	@OneToMany(fetch = FetchType.EAGER)
	private List<User> passengers;
	public int getPnrNo() {
		return pnrNo;
	}
	public void setPnrNo(int pnr) {
		this.pnrNo = pnr;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
//	public Flight getFlight() {
//		return flight;
//	}
//	public void setFlight(Flight flight) {
//		this.flight = flight;
//	}
	public List<User> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<User> passengers) {
		this.passengers = passengers;
	}
	
}
