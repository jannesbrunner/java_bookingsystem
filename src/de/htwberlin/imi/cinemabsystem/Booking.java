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
	
	public void printAllTickets(){
		
		for (Ticket ticket : tickets){
		
		System.out.println("#################################################");
		System.out.println("###               JEM-Cinema                  ###");
		System.out.println(" ## Theater  Seat  Row             Price      ## ");
		System.out.println("###" +ticket.getTheater() + " " + ticket.getSeat().getSeatNum() + " " + ticket.getSeat().getRow() + "    " + ticket.getMovie().getPrice() +        "      ###");
		System.out.println(" ## Movie                                     ## ");
		System.out.println("### " + ticket.getMovie().getTitle().substring(0, 30) + "                   ###");
		System.out.println("#################################################\n");
		System.out.println();
		}
	}
}
