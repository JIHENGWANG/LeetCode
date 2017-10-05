package practiceEasy;
import java.util.*;
public class CountandSay {
	/*
	 * Assumptions: 
	 * if n < 2, then return 1;
	 * 
	 * Step: each string in current n comes from the last string in n - 1.
	 * 		 from 0 to the length of last, if last.charAt(i - 1) == last.charAt(i)
	 * 		 until the next char is not equal to to the current char. or the length of
	 * 		 String is reached. 
	 * 		 Add the count and add the last.charAt(i - 1) to our stringBuilder when 
	 * 	     charAt(i - 1) != last.charAt(i) and when i hits the end of string.
	 * 
	 * Time: O(n^2) Space O(n)
	 */
	public static String countAndSay(int n) {
        if(n < 2){
        	return "1";
        }
        String sol = "1";
        for(int i = 2; i <= n; i++){
        	sol = readFrom(sol);
        }
        return sol;
    }
	
	private static String readFrom(String last){
		StringBuilder now = new StringBuilder();
		int count = 0;
		for(int i = 0; i < last.length(); i++){
			if(i == 0 || last.charAt(i - 1) ==  last.charAt(i)){
				count++;
			}else {
				now.append(Integer.toString(count));
				now.append(last.charAt(i - 1));
				count = 1;
			}
		}
		now.append(Integer.toString(count));
		now.append(last.charAt( last.length()- 1));
		return now.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(countAndSay(6));
		System.exit(0);
	}

}
