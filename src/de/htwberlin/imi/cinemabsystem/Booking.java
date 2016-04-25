package de.htwberlin.imi.cinemabsystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Booking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Ticket> tickets;
	
	public Booking() {
		this.tickets = new ArrayList<Ticket>();
	
	}
	
	public void addTicket(Ticket ticketToAdd){
		
		tickets.add(ticketToAdd);
	}
	
	public void rmvTicket(Ticket ticketToRmv){
		
		tickets.remove(ticketToRmv);
	}
	
	public String printSeats(){
		
		String allTickets = "";
		for (Ticket ticket: tickets) {
		    allTickets = allTickets + ticket.getSeat().getSeatNum() + ticket.getSeat().getRow() + " " ;
		}
		return allTickets;
	}
	
	public String printSeat(Ticket ticketToPr){
		
		String oneTicket = "";
		for (Ticket ticket: tickets) {
			
			if (ticket == ticketToPr)
		    oneTicket = oneTicket + ticket.getSeat().getSeatNum() + ticket.getSeat().getRow() + " " ;
		    return oneTicket;
		}
		return oneTicket;
		
	}
	
	public void printAllTickets(){
		
		
		for (Ticket ticket : tickets){
		
		System.out.println("Ticket #  " + ticket.getTicketNum() + " for the movie " + ticket.getMovie().getTitle());	
		System.out.println("#################################################");
		System.out.println("###               JEM-Cinema                  ###");
		System.out.println(" ##                                           ## ");
		System.out.println("###  Theater  Seat                 Price      ###");
		System.out.println(" ##                                           ##");
		System.out.println("###  " +ticket.getTheater().getTheaterNum() + "        " + ticket.getSeat().getSeatNum() + ticket.getSeat().getRow() + "                   " + ticket.getMovie().getPrice() +             "       ### ");
		System.out.println("#################################################\n");
		System.out.println();
		}
		
		System.out.println("Total price of all tickets: " + getTotalPrice());
	}
	
	
	public double getTotalPrice(){
		
		double totalPrice = 0;
		for (Ticket ticket : tickets){
			totalPrice = totalPrice + ticket.getMovie().getPrice();
		}
	
		return totalPrice;
	}
	
	public int getAmountoftickets() {
		return this.tickets.size();
	}
	
	// returns 0 if there is no ticket yet
	public int getHighesticketno() {
		int number = 0; 
		try {
			for (Iterator<Ticket> iterator = tickets.iterator(); iterator.hasNext();) {
				Ticket ticket = (Ticket) iterator.next();
				if (ticket.getTicketNum() > number ) number = ticket.getTicketNum();
			}
		} catch (NullPointerException e) {
			number = 0;
			
		} return number;
	}
}
