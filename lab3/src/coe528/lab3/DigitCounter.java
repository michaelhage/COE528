package coe528.lab3;


public class DigitCounter extends AbstractCounter{
   
   public DigitCounter(int value){
       this.setValue(value);
   }
   
   @Override
   public void increment(){
       if(this.getValue() == 9){
           this.setValue(0);
       }
       else{
            this.setValue( this.getValue() + 1 );
       }
   }
   
   @Override
   public void decrement(){
       if(this.getValue() == 0){
           this.setValue(9);
       }
       else{
            this.setValue( this.getValue() - 1 );
       }
       
   }
   
   @Override
   public void reset(){
       this.setValue(0);
   }
   
   @Override
   public String count(){
       return Integer.toString( this.getValue() );
   }
}