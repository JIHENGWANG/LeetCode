package practiceHard;

public class TrappingRainWater {
	/*
	 * if height is null or empty, return 0;
	 * 
	 * Time: o(n), Space: o(1);
	 */
	public int trap(int[] height) {
		if(height == null || height.length == 0){
			return 0;
		}
		int start = 0;
		int end = height.length - 1;
		int leftMax = 0;
		int rightMax = 0;
		int trapped = 0;
		while(start <= end){
			leftMax = Math.max(leftMax, height[start]);
			rightMax = Math.max(rightMax, height[end]);
			if(leftMax < rightMax){
				trapped += leftMax - height[start++];
			} else {
				trapped += rightMax - height[end--];
			}
		}
		return trapped;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
