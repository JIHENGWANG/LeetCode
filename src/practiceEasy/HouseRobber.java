package practiceEasy;

import java.util.Arrays;

public class HouseRobber {
	/*
	 * Max value of a thief can steal.
	 * 
	 * Important Info: Thief cannot steal two adjacent houses.
	 * 
	 * Assumptions: The array of values in house is not empty.
	 * 				The value in every house is positive. 
	 * 
	 * Method Signture: stealValue
	 * 
	 * Input parameter: int [] houses. An array that represents houses and each element
	 * 					of array is the value that each house has.
	 * 
	 * Return Statement: return an integer that represent the max value that thief can
	 * 				 	 steal without stealing any two adjacent houses.
	 * 
	 * Steps: Use dynamic programming to solve this problem.
	 * 		  Create variable : currMax saves the maxValue from 0 to i-1th houses
	 * 		                    lastMax saves the maxValue from 0 to i-2th houses.
	 * 		
	 * 		  Induction Rule of our dynamic programming:
	 * 		  Base Case: n = 1; so currMax = houses[0];
	 * 					 n = 2; currMax = Math.max(currMax, houses[1])
	 * 		  			
	 * 		  n >= 3: Follow our induction rule: 
	 * 				  ith MaxValue = max(i-1th MaxValue, i-2thMaxValue + houses[i])
	 * 				 
	 * 				  create a temp value to save currMax,
	 * 				  currMax = Math.max(currMax, lastMax + houses[i])
	 * 				  lastMax = temp;
	 * 				  Maintain and update currMax and lastMax until whole array is
	 * 				  looped.
	 * 
	 * Return the currMax that represents the max value that thief can steal.
	 * 
	 * Time complexity: o(n). Space Complexity: o(1)
	 */
	
	public static int stealValue(int[] nums) {
        int currMax = 0;
        int lastMax = 0;
        for(int i = 0; i < nums.length; i++){
        	int tempVal = currMax;
        	currMax = Math.max(currMax, lastMax + nums[i]);
        	lastMax = tempVal;
        }
        return currMax;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test Case 1
		String w = "skahdfasdf";
		char[] array = w.toCharArray();
		Arrays.sort(array);
		
		for(char c : array){
			System.out.print(c);
		}
		System.out.println("");
		for(int i = 0; i < w.length(); i++){
			System.out.print(w.charAt(i));
		}
		System.exit(0);
	}

}
