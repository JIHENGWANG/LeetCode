package practiceMedium;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArrayII {
	/*
	 * Assumptions:
	 * If array is not or length of array <= 2, then return array directly.
	 * 
	 * Steps: Keeping two duplicate numbers, we don't need to check the first
	 * 		  first element in array. So we start from second one.
	 * 		  1. if array[fast] == array[slow - 1], then fast++;
	 * 		  2. if array[fast] != array[slow - 1], then array[++slow] = array[fast++]
	 * 
	 * Return the array with at most two duplicate numbers.
	 * 
	 * Time: o(n), Space:o(1)
	 */
	
	public static int[] remove(int[] array){
		if(array == null || array.length <= 2){
			return array;
		}
		int slow = 1;
		for(int fast = 2; fast < array.length; fast++){
			if(array[fast] != array[slow - 1]){
				array[++slow] = array[fast];
			}
		}
		return Arrays.copyOf(array, slow + 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
