/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flightbooking;

/**
 *
 * @author mhage
 */
public class Ticket {
   
    private Passenger passenger;
    private Flight flight;
    private double price;
    private int number; //unique ticket number
    
    public Ticket(Passenger passenger, Flight flight, double price){
        this.passenger = passenger;
        this.flight = flight;
        this.price = price;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    @Override
    public String toString(){
        return (passenger.getName() + ", Flight " + flight.getFlightNumber() + ", " + flight.getOrigin() 
                + " to " + flight.getDestination() + ", " + flight.getDepartureTime()
                + ", original price: $" + flight.getOriginalPrice() + ", ticket price $"
                + this.price + "\n");
    }
}
