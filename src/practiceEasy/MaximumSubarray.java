package practiceEasy;

import java.lang.reflect.Array;

public class MaximumSubarray {
	/*
	 * Assumptions:
	 * If nums is null or empty, then return 0;
	 * 
	 * Steps:
	 * 		Create totalSum and currSum and represent the maximum sum of whole array
	 * 	    and the maximum sum from 0 to ith element in array. update the currentSum and
	 * 		totalSum in iterative way
	 * 
	 * Return the totalSum
	 * 
	 * Time: o(n), Space: O(1)
	 */
	public static int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        int currSum = 0;
        int totalSum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
        	currSum = Math.max(nums[i], currSum + nums[i]);
        	totalSum = Math.max(currSum, totalSum);
        }
        return totalSum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-4,-6,-2,-3};
		System.out.print(maxSubArray(nums));
		System.exit(0);

	}

}
