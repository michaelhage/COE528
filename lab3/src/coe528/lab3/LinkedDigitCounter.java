package coe528.lab3;

/**
 *
 * @author mhage
 */
public class LinkedDigitCounter extends AbstractCounter{
    
    private Counter leftDigit;
    
    public LinkedDigitCounter(int value, Counter leftDigit){
        this.setValue(value);
        this.leftDigit = leftDigit;
    }
    
    @Override
    public void increment(){
        if(this.getValue() == 9){
            this.setValue(0);
            leftDigit.increment();
        }
        else{
            this.setValue( this.getValue() + 1 );
        }
    }
    
    @Override
    public void reset(){
        this.setValue(0);
    }
    
    @Override
    public void decrement(){
        if(this.getValue() == 0){
            leftDigit.decrement();
            this.setValue(9);
        }
        else{
        this.setValue( this.getValue() - 1 );
        }
    }
    
    @Override
    public String count(){
        return Integer.toString( this.getValue() );
    }
}