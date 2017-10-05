package practiceEasy;
import java.util.*;
public class TwoSum {
	/*
	 * Assumptions: Arrays are at least two elements
	 * 
	 * Steps: Use a map to store each number and its index, if found out target equals the current number plus a number in map,
	 * 		  then make it a new array and return it. If not found, then just return an empty array.
	 * 
	 * Return a array of solutions
	 * 
	 * Time Complexity : o(n) Space: o(n)
	 */
	
	public static int[] twoSum(int[] nums, int target) {
		// Write your solution here.
		if(nums.length == 2){
			return nums[0] + nums[1] == target ? new int[] {0, 1} : new int[] {};
		}
		Map<Integer, Integer> map = new HashMap<> ();
		for(int i = 0; i < nums.length; i++){
			if(map.containsKey(target - nums[i])){
				return new int[]{map.get(target - nums[i]), i};
			}
			map.put(nums[i], i);
		}
		return new int[] {};
	}
  public static void main(String[] args) {
		// TODO Auto-generated method stub
	  int[] nums = {2, 7, 11, 15};
	  int[] sol = twoSum(nums, 9);
	  for(int num : sol)
		  System.out.print(num + " ");
	  System.exit(0);
  }

}
