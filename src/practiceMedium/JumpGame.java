package practiceMedium;

public class JumpGame {
	/*
	 * Assumptions: if nums is null or empty, return true;
	 * 
	 * Steps: we start from the last second element from the array, if
	 * 		  the value of current element can reach the last element, then
	 * 		  update the lastPos to current position. any element that can
	 * 		  reach the current position will also be able to reach the last position.
	 * 
	 * 
	 * Return a boolean
	 * 
	 * Time: o(n^2) Space: o(n)
	 */
	public boolean canJump(int[] nums) {
		int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
