package coe528.lab3;

//A basic up-down counter
public interface Counter {
    
    //The current value of this Counter as a String of digits.
    String count();

    //Increment this Counter.
    void increment();

    //Decrement this Counter.
    void decrement();

    //Reset this Counter.
    void reset(); 
}
