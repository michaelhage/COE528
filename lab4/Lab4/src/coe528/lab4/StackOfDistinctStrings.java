package coe528.lab4;

import java.util.ArrayList; 

public class StackOfDistinctStrings { 
    // Overview: StacksOfDistinctStrings are mutable, bounded     
    // collection of distinct strings that operate in  
    // LIFO (Last-In-First-Out) order.  
    // 
    // The abstraction function is:
    // a)Write the abstraction function here 
    // AF(c) = a Stack of strings p
    //  p = {c.items.get(i) for i in the range, 0 <= i < c.items.size()
    //  && c.items.contains( c.items.get(i) ) == false. for all i
    // 
    //
    // The rep invariant is:
    // b)Write the rep invariant here
    //  RI(c) = true if all strings are distinct, therefore no copies
    //  && all elements are strings within the stack
    //  && the top of the stack is items.size() - 1
    // 
    //
    //the rep 
    private ArrayList<String> items; 
    // constructor 
    public StackOfDistinctStrings() { 
        // EFFECTS: Creates a new StackOfDistinctStrings object 
        items = new ArrayList<String>();
    } 
    public void push(String element) throws Exception { 
        // MODIFIES: this 
        // EFFECTS: Appends the element at the top of the stack  
        //          if the element is not in the stack, otherwise 
        //          does nothing. 
        if(element == null) throw new Exception(); 
        if(false == items.contains(element))  
            items.add(element); 
    } 
    public String pop() throws Exception { 
        // MODIFIES: this 
        // EFFECTS: Removes an element from the top of the stack  
        if (items.size() == 0) throw new Exception(); 
        return items.remove(items.size()-1); 
    } 
    public boolean repOK() { 
        // EFFECTS: Returns true if the rep invariant holds for this    
        //          object; otherwise returns false    
    // c) Write the code for the repOK() here 
        
        for(int i = 0; i < items.size();i++){
            if(items.get(i) instanceof String == false) return false;
            for(int j = i + 1; j < items.size(); j++){
                if(items.get(i).equals( items.get(j) )) return false;
            }
        }
        
        return true;
    } 
    
    @Override
    public String toString() { 
        // EFFECTS: Returns a string that contains the strings in the  
        //          stack and the top element. Implements the  
        //          abstraction function.   
    // d) Write the code for the toString() here 
        String s = "The strings in the stack:";
        if( this.repOK() == false) return "The stack doesn't contain distinct strings";
        else if( items.isEmpty() ) return "There aren't any values";
        
        for(int i = 0; i < items.size(); i++){
            s += " " + items.get(i);
        }
        return s + ".";
    }
    
    //Used to test the methods
    public static void main(String[] args){
        StackOfDistinctStrings s = new StackOfDistinctStrings();
        
        try{
        
            s.pop();
            
            s.push("ab");
            s.push("cd");
        
            //pushes a non distinct element into the stack
            s.push("ab");
        
            //s.items.add("ab");
            
            //invokes the toString method
            System.out.println( s.toString() );
        }
        catch(Exception ex){
            System.out.println("An Error has occured");
        }
    }
} 
