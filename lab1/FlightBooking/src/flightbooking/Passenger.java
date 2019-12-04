/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flightbooking;

/**
 *
 * @author mhage
 */
abstract public class Passenger {
    private String name;
    private int age;
    
    
    public Passenger(String name, int age){
        this.name = name;
        this.age = age;
    }
    
    abstract double applyDiscount(double p);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
