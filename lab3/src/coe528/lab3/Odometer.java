package coe528.lab3;

public class Odometer implements Counter{
    private AbstractCounter[] linkedList;
    
    public Odometer(int n){
        
        if(n < 1){
            throw new IllegalArgumentException();
        }
        
        linkedList = new AbstractCounter[n];
        
        for(int i = 0; i < n; i++){
            
            if(i == 0){
                linkedList[i] = new DigitCounter(0);
            }
            
            else{
            linkedList[i] = new LinkedDigitCounter(0, linkedList [i - 1]);
            }
        }
    }
    
    @Override
    public void increment(){
        
        linkedList[linkedList.length - 1].increment();
    }
    
    @Override
    public void decrement(){
        
        linkedList [linkedList.length - 1].decrement();
    }
    
    @Override
    public void reset(){
        for(AbstractCounter counter: linkedList){
            counter.reset();
        }
    }
    
    @Override
    public String count(){
        String s = "";
        for(AbstractCounter counter: linkedList){
            s += counter.count();
        }
        return s;
    }
    
    public Counter getCounter(int index){
        return linkedList[index];
    }
}
