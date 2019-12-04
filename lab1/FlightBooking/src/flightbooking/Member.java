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
public class Member extends Passenger{
    private int yearsOfMembership;
    
    public Member(String name, int age, int yearsOfMembership){
        super(name, age);
        this.yearsOfMembership = yearsOfMembership;
    }
    
    @Override
    public double applyDiscount(double p){
        if(yearsOfMembership > 5){
            return(0.5 * p);
        }
        else if(1 < yearsOfMembership &&  yearsOfMembership <= 5){
            return(0.9 * p);
        }
        else{
            return(p);
        }
    }
}
