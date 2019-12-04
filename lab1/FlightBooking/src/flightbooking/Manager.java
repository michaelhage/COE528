/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightbooking;

import java.util.ArrayList;
/**
 *
 * @author Michael Hage
 */
public class Manager {
    
    private ArrayList<Flight> flightList = new ArrayList();
    private ArrayList<Passenger> passengerList = new ArrayList();
    private ArrayList<Ticket> ticketList = new ArrayList();
    
    public Manager(){
        ArrayList<Flight> flightList = new ArrayList();
        ArrayList<Passenger> passengerList = new ArrayList();
        ArrayList<Ticket> ticketList = new ArrayList();
    }
    
    
    public void createFlight(int flightNumber, String origin, String destination,
            String departureTime, int capacity, double originalPrice){
        
        Flight flight = new Flight(flightNumber, origin, destination,
            departureTime, capacity, originalPrice);
        
        flightList.add(flight);
    }
    
    public Flight getFlight(int flightNumber){
        for(int i = 0; i < flightList.size(); i++){
            if(flightNumber == flightList.get(i).getFlightNumber()){
                return flightList.get(i);
            }
        }
        return null;
    }
    
    public void displayAvailableFlights(){
        
        for(int i = 0; i < flightList.size(); i++){
            
            if(flightList.get(i).getNumberOfSeatsLeft() != 0){
                
                System.out.println(flightList.get(i).getOrigin() + " to " + flightList.get(i).getDestination() + "\n");
            }
        }
        
    }
    
    public void bookSeat(int flightNumber, Passenger p){
        Flight flight = getFlight(flightNumber);
        
        if(flight == null){
            throw new IllegalArgumentException("Flight doesn't exist");
        }
        
        if(flight.bookASeat()){
            flight.setNumberOfSeatsLeft();
            ticketList.add(new Ticket(p, flight, p.applyDiscount(flight.getOriginalPrice())));
        }
        else{
            throw new IllegalArgumentException("There aren't any seats left on the plane");
        }
    }
    
    
    public static void main(String[] args){
        
        Manager m = new Manager();
        
        m.createFlight(1030,"Toronto","Los Angeles","03/02/99 7:50pm", 3, 100.00);
        
        m.createFlight(2030, "Los Angeles", "Tokyo", "04/02/99 2:00pm", 7, 200.00);
        
        //adding the passengers
        m.passengerList.add(new Member("Elon Musk", 47, 8));     //0
        m.passengerList.add(new Member("Gary Oak", 25, 2));      //1
        m.passengerList.add(new Member("Kawhi Leonard", 30, 1)); //2
        m.passengerList.add(new NonMember("Michael Hage", 20));  //3
        m.passengerList.add(new NonMember("Greg Monroe", 70));   //4
        m.passengerList.add(new NonMember("Angela Simmons", 65));//5
        
        //booking the seats of the flights for the passengers
        //First flight
        m.bookSeat(m.flightList.get(0).getFlightNumber(), m.passengerList.get(0));
        m.bookSeat(1030, m.passengerList.get(1));
        m.bookSeat(1030, m.passengerList.get(3));
        
        //Second flight
        m.bookSeat(m.flightList.get(1).getFlightNumber(), m.passengerList.get(2));
        m.bookSeat(m.flightList.get(1).getFlightNumber(), m.passengerList.get(0));
        m.bookSeat(m.flightList.get(1).getFlightNumber(), m.passengerList.get(5));
        m.bookSeat(m.flightList.get(1).getFlightNumber(), m.passengerList.get(1));
        
        //will trigger an illegal argument exception
        //bookSeat(1030, passengerList.get(4)); //There isn't enough room on the plane
        //bookSeat(2040, passengerList.get(3)); //Flight Doesn't Exist
        
        
        //displays available fligts
        System.out.println("Availible Flights\n");
        m.displayAvailableFlights();
        
        //Testing the toString Methods of the Flight and Ticket Classes
        
        System.out.println("Tickets\n");
        for(int i = 0; i < m.ticketList.size(); i++){
            
            System.out.println(m.ticketList.get(i).toString());
        }
        
        System.out.println("All Flights\n");
        for(int i = 0; i < m.flightList.size(); i++){
            
            System.out.println(m.flightList.get(i).toString());
        }
        
     }
        
}
