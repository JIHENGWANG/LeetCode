package practiceEasy;
import java.util.*;
public class RemoveElement {
	/*
	 * Assumptions: 
	 * If array is null or empty, then return 0;
	 * 
	 * Steps:
	 * 		Use a slow pointer.
	 * 		Iterate the whole array, if any element not equals target, then 
	 * 		nums[slow++] = nums[i].
	 * 
	 * return slow.
	 * 
	 * Time Complexity: o(n), Space: o(1)
	 */
	public static int removeElement(int[] nums, int val) {
		if(nums == null || nums.length == 0){
	        return 0;
		}
		int slow = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] != val){
				nums[slow++] = nums[i];
			}
		}
		return slow;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,2,2,3};
		System.out.print(removeElement(nums, 2));
		System.exit(0);

	}

}
