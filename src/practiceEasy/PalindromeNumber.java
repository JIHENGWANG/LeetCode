package practiceEasy;
import java.util.*;
public class PalindromeNumber {
	/*
	 * Assumptions:
	 * Case 1: if x < 0, then return false because a negative number is not Palindrome
	 * Case 2: if the last digit of x is zero, that is x % 10 = 0. then return false.
	 * 
	 * Steps: Use the original number X to module 10 to get the last digits and store it to a temp
	 * 		  and x = x /10;
	 * 	      if x == temp || x == tep / 10; then return true.
	 * 		  This can handle odd and even length of numbers.
	 * 
	 * Return true if a number is Palindrome.
	 * Time Complexity: O(log10n) Space: O(1)
	 */
	public static boolean isPalindrome(int x) {
        if(x < 0 || x % 10 == 0 && x != 0){
        	return false;
        }
        int lastDigits = 0;
        while(x > lastDigits){
        	lastDigits = x % 10 + lastDigits * 10;
        	x = x / 10;
        }
		return x == lastDigits || x == lastDigits / 10;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(isPalindrome(1));
		System.exit(0);

	}

}
