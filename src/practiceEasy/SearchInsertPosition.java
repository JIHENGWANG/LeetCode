package practiceEasy;
import java.util.*;
public class SearchInsertPosition {
	/*
	 * Assumptions:
	 * 		If array is null or empty, then return 0.
	 * Steps:
	 *		Find the mid of sorted array, if array[mid] < target, then
	 *		left = mid; else if array[mid] => target, then right = mid.
	 *
	 * Return left + 1 if(nums[left] < target <= nums[right]);
	 * 		  right + 1 if(target > nums[right];
	 * 		  left if (nums[left] > nums) 
	 * 
	 * Time: o(logn) Space: n(1)
	 * 
	 */
	public static int searchInsert(int[] nums, int target) {
		if(nums == null || nums.length == 0){
			return 0;
		}
		int left = 0, right = nums.length - 1;
		while(left < right - 1){
			int mid = left + (right - left)  / 2;
			if(nums[mid] >= target){
				right = mid; 
			} else {
				left = mid;
			}
		}
		if(nums[right] < target){
			return right + 1;
		} else if(nums[left] < target){
			return left + 1;
		}
		return left;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,3,5,6};
		System.out.print(searchInsert(nums, 2));
		System.exit(0);

	}

}
