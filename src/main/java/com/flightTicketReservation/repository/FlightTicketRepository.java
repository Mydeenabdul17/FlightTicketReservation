package com.flightTicketReservation.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.flightTicketReservation.dto.Flight;
import com.flightTicketReservation.dto.Ticket;
import com.flightTicketReservation.dto.User;

public class FlightTicketRepository {

	private static FlightTicketRepository repository;
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	private FlightTicketRepository() {
		
	}
	public static FlightTicketRepository getInstance() {
		if(repository==null) {
			repository = new FlightTicketRepository();
		}
		return repository;
	}
	public void addFlight(Flight flight) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(flight);
		et.commit();
	}
	public List<Flight> getFlights(String from, String to) {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT f FROM Flight f WHERE f.routes LIKE :route");
		q.setParameter("route", "%"+from+"%"+to+"%");
		List<Flight> flights = q.getResultList();
		return flights;
	}
	public void bookTicket(Ticket t) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(t);
//		String hql = "INSERT INTO Ticket (from, status, to, total) VALUES (:from, :status, :to, :total)";
//		Query query = em.createQuery(hql);
//		query.setParameter("from", t.getFrom());
//		query.setParameter("status", t.getStatus());
//		query.setParameter("to", t.getTo());
//		query.setParameter("total", t.getTotal());
//		int result = query.executeUpdate();

		for(User u: t.getPassengers()) {
			em.persist(u);
		}
		et.commit();
		
	}
	public Ticket getTicket(int pnr) {
		EntityManager em = emf.createEntityManager();
		Ticket t = em.find(Ticket.class, pnr);
		return t;
	}
	public List<Ticket> getAllTickets() {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select t from Ticket t");
		return q.getResultList();
	}
	public void changeStatus(Ticket t) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(t);
		et.commit();
	}
	public User findPassenger(int id) {
		EntityManager em = emf.createEntityManager();
		return em.find(User.class, id);
	}
}
