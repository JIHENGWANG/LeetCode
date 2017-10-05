package practiceMedium;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArrayIII {
	/*
	 * Assumptions:
	 * If array is null or empty, then return array;
	 * 
	 * Steps: We need to remove all elements that has duplicates. only 
	 * 		  keep the elements don't have duplicates.
	 * 		  1. let slow == -1, and fast == 0;
	 *           if(slow == -1 || array[slow] != array[fast])
	 *           then array[++slow] = array[fast++];
	 *        2. if array[slow] == array[fast]
	 *        	 as long as fast + 1 != array.length,
	 *           fast++ until array[slow] != array[fast + 1], and then slow--.
	 *        
	 * Return the array that has been modified.
	 * 
	 * Time: o(n), Space: o(1)
	 */
	public static int[] remove(int[] array){
		if(array == null || array.length <= 2){
			return array;
		}
		int slow = -1;
		for(int fast = 0; fast < array.length; fast++){
			if(slow == -1 || array[fast] != array[slow]){
				array[++slow] = array[fast];
			} else {
				while(fast + 1 < array.length && array[fast + 1] == array[slow]){
					fast++;
				}
				slow--;
			}
		}
		return Arrays.copyOf(array, slow + 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {1, 1, 2, 3, 3, 3, 2, 4, 5, 6, 7, 7, 8, 2};
		array = remove(array);
		for(int num: array){
			System.out.println(num);
		}

	}

}
