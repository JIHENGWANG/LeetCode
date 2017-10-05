package practiceEasy;
import java.util.*;
public class ImplementStrstr {
	/*
	 * Assumptions: 
	 * Case 1: if the haystack or is null or empty, then return -1
	 * Case 2: if the length of needle is greater than haystack, then return -1.
	 * 
	 * Steps: iterate the whole heystack, see if any substring from current position
	 * 		   equals the needle, if it is, then return the current position.
	 * 
	 * Return a number that represent the first occurrence of needle
	 * 
	 * Time Complexity: o(n^2) Space: o(1)
	 */
	public static int strStr(String haystack, String needle) {
		if(haystack == null || needle == null){
			return -1;
		}
		if(needle.length() > haystack.length()){
			return -1;
		}
		for(int i = 0; i < haystack.length(); i++){
			if(i + needle.length() >= haystack.length()){
				break;
			}
			if(haystack.substring(i, i + needle.length()).equals(needle)){
				return i;
			}
		}
		return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "a";

		String h = "a";
		System.out.print(strStr(s, h));
		System.exit(0);
	}

}
