package practiceEasy;
import java.util.*;
public class RemoveDuplicatesfromSortedArray {

	/*
	 * Assumptions:
	 * If Array of nums is null or empty, then return zero
	 * 
	 * Steps:
	 * 		Use two pointers to check the duplicates. numbers include slow pointer is the 
	 * 		final correct array that we need to return. numbers behind fast pointer is the unknown
	 * 		area. if found array[slow] == array[fast], then fast++ until they are not equal, then  
	 * 		array[++slow] == array[fast++];
	 * return length of the numbers from 0 to slow or return the array from 0 to slow;
	 * 
	 * Time Complexity: O(n), Space: o(1)
	 */
	
	public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        int slow = 0;
        for(int i = 1; i < nums.length; i++){
        	if(nums[slow] != nums[i]){
        		nums[++slow] = nums[i];
        	}
        }
        return slow + 1;
    }
	
	/*
	 * o(1) way to do that
	 */
	public static int removeDuplicatesTwo(int[] nums){
		if(nums == null || nums.length == 0){
        	return 0;
        }
		return nums[0] == nums[nums.length - 1] ? 1 : nums[nums.length - 1] - nums[0] + 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  int[] nums = {2, 3, 5, 8, 8, 9, 10};
	  System.out.print(removeDuplicates(nums));
	  System.exit(0);
  }
}
