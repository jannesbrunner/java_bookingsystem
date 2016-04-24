package de.htwberlin.imi.cinemabsystem;

import java.util.ArrayList;

public class Booking {

	ArrayList<Ticket> tickets;
	
	public Booking(ArrayList<Ticket> tickets){
		this.tickets = tickets;
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
}
