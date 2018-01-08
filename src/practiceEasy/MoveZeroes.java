package practiceEasy;

public class MoveZeroes {
	/*
	 * Assumptions: if nums is null or empty, then return void,
	 * Steps: need slow fast pointers. as long as fast pointer is not zero,
	 * 		  we swap the values in slow and fast pointers, and increment them until
	 * 		  the length of array is reached.
	 * 
	 * return an array.
	 * Time Complexity: o(n) Space: o(1)
	 */
	public static void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0){
        	return;
        }
        int slow = 0;
        for(int i = 0; i < nums.length; i++){
        	if(nums[i] != 0){
        		int temp = nums[i];
        		nums[i] = nums[slow];
        		nums[slow++] = temp;
        	}
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 0, 15, 0, 6, 0, 7};
		moveZeroes(nums);
		for(int num : nums){
			System.out.print(num +  " ");
		}
	}

}
