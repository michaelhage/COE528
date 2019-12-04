/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab2;

/**
 *
 * @author mhage
 */
public class Palindrome {

    
//Requires: Ant object of type string
//Effects: returns a boolean which determines if the string is a palindrome

    
    public static boolean isPalindrome(String a) {
        
        if(a == null  || a.equals("")){
           return false;
        }
        
        int i1 = 0;
        int i2 = a.length() - 1;
        
        while(i2 > i1){
            
            //check to see if two chars are equal
            if(a.charAt(i1) != a.charAt(i2)){
                return false;
            }
            i1++;
            i2--;
        }
        
        return true;
    }//end isPalindrome


    public static void main(String[] args) {
            
        args = new String[1];
        args[0] = "2";
            
            
        if(args.length == 1) {
            if (args[0].equals("1")){
                System.out.println(isPalindrome(null));
            }//end else if
            
            else if (args[0].equals("2")){
                System.out.println(isPalindrome(""));
            }//end else if
            
            else if (args[0].equals("3")){
                System.out.println(isPalindrome("deed"));
            }//end else if
            
            else if (args[0].equals("4")){
                System.out.println(isPalindrome("abcd"));
            }//end else if
            
        }//end if
    }//end main

}//end palindrome
