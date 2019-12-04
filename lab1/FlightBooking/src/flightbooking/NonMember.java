/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightbooking;

/**
 *
 * @author Michael Hage
 */
public class NonMember extends Passenger{

    public NonMember(String name, int age) {
        super(name, age);
    }
    
    @Override
    public double applyDiscount(double p){
        if(this.getAge() >= 65){
            return(0.9 * p);
        }
        else{
            return p;
        }
    }
}
