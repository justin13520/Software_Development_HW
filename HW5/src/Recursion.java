
/**
 * Homework 5
 * 
 * Implement the following methods on recursion
 * as defined in the homework 5 document.
 * 
 * @author Justin Liu ( jl8wf ) 
 *
 */
public class Recursion {//class of recursions
    
    public static boolean palindrome(String s) {//checks if its a palindrome
        if(s.length() == 1 || s.length() == 0) {//if its length 1 or 0, theres no need to confirm, already is a palindrome
        	return true;
        }
        if(s.charAt(0) == s.charAt(s.length()-1)) {//checks to see if the first and last are the same
        	return palindrome(s.substring(1,s.length()-1));//recursed back in with the same letters chopped off and checks again
        }
        return false;//false if there is just once that the letters dont match up
    }
    
    public static String reverseString(String s) {//reverses the string
    	if (s.length() == 0) {
            return s;
    	}
        return reverseString(s.substring(1)) + s.charAt(0);//pops back into the method with a chopped off String with the first letter added on.
        //because the letter added isnt in the substring, the substring get smaller and smaller until it is length 0, which then all the letters 
        //added at the end come together, reversing the String
    
    }
    
    public static int handshakes(int n) {//number of handshakes if one person can handshake another person once only
        if(n == 0) {
        	return n;
        }
        return handshakes(n-1)+n-1;//for each group, 1 person can shake n-1 times
        //this continues until the group is only one person, which is then when the
        //recursion terminates
    }    
    
    public static long ackermann(long m, long n) {//ackermann recursion
        if(m == 0) {
        	return n+1;
        }
        if(m > 0 && n == 0) {
        	return ackermann(m-1, 1);
        }
        if(m > 0 && n> 0) {
        	return ackermann(m-1, ackermann(m, n-1));
        }
        return 1;
    }
    


    public static void main(String[] args) {//testing
        System.out.println(palindrome("abba"));
        System.out.println(palindrome("racecar"));
        System.out.println(palindrome("ertre"));
        System.out.println( palindrome("apple"));
        System.out.println(reverseString("apple"));
        System.out.println(reverseString("racecar"));
        System.out.println(reverseString("I love CS!"));
        System.out.println(handshakes(2));
        System.out.println(handshakes(3));
        System.out.println(handshakes(4));
        System.out.println(ackermann(0, 0));
        System.out.println(ackermann(2, 0));
        System.out.println(ackermann(1, 1));
           }
}