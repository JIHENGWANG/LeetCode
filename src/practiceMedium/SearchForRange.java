package practiceMedium;

import java.lang.reflect.Array;

public class SearchForRange {
	/*
	 * search a target in array, and return its range
	 * 
	 * Assumptions: if array is null or empty, then return [-1, -1]
	 * 		   		if array[length - 1] < target, return [-1, -1]
	 * 			 	if array[0] == array[length - 1] && nums[0] == target, 
	 * 				return [0, length - 1]
	 * 
	 * Steps: Use binary search. make sure the target is always within the range
	 * 		  while(left <= right)
	 * 		  mid = left + (right - left) / 2
	 * 		  if(array[mid] == target), then we can break;
	 * 		  else if (array[mid] > target), then we let right = mid
	 * 		  else we let left = mid.
	 * 
	 * return the range
	 * 
	 * Time: o(logn) space: o(1)
	 */
	public static int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
        	return new int[]{-1,-1};
        }
        if(nums[nums.length - 1] < target){
        	return new int[]{-1,-1};
        }
        if(nums[0] == nums[nums.length - 1] && nums[0] == target){
        	return new int[] {0, nums.length - 1};
        }
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while(left <= right){
        	mid = left + (right - left) / 2;
        	if(nums[mid] == target){
        		break;
        	}
        	else if(nums[mid] < target){
        		left = mid + 1;
        	} else {
        		right = mid - 1;
        	}
        }
        if(left > right){
        	return new int[] {-1, -1};
        }
        int[] sol = new int[2];
        int po = mid;
        left = 0; 
        right = nums.length - 1;
        while(left <= po){
        	int middle = left + (po - left) / 2;
        	if(nums[middle] == target){
        		sol[0] = middle;
        		po = middle - 1;;
        	} else {
        		left = middle + 1;
        	}
        }
        po = mid;
        while(po <= right){
        	int middle = po + (right - po) / 2;
        	if(nums[middle] == target){
        		sol[1] = middle;
        		po = middle + 1;
        	} else {
        		right = middle - 1;
        	}
        }
        return sol;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {5, 7, 7, 8, 8, 8};
		int[] sol = searchRange(array, 7);
		for(int num : sol){
			System.out.print(num + " ");
		}
	}

}
