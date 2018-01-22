package practiceMedium;

import java.util.Deque;
import java.util.LinkedList;

public class ContainerWithMostWater {
	
	/*
	 * Assumptions:
	 * If array == null or array is empty, then return 0;
	 */
	public int maxArea(int[] height) {
		int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
