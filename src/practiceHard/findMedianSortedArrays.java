package practiceHard;
import java.util.*;
public class findMedianSortedArrays {
	/*
	 * Assumptions:
	 * If either nums1 or nums2 or empty, then we return the median of the other array
	 * 
	 * Steps:
	 * 		1. length = nums1.length + nums2.length
	 * 		   1.1 if length % 2 != 0, then we findMedian(nums1, nums2, (length + 1) / 2)
	 * 			   Otherwise we findMedian(nums1, nums2 (length) / 2) and (nums1, nums2 (length + 1) / 2)
	 * 	           add these two numbers together and divided by 2.
	 * 		2. Find kth smallest number in two sroted array when k == median use binary search
	 * 	       2.1: Base case: if any array is empty, then return the median from the other array.
	 * 				If K == 1, then return min(nums1[current], nums2[current]
	 * 		   2.2: find the k/2th number in nums1 and k/2th number in nums2
	 * 				If nums1[k/2 - 1] > nums2[k/2 - 1], then we don't need to check 0 - k/2th number
	 * 			    in nums2. we started from k/2 in nums2. k = k/2 * 1/2 = k/4
	 * 				if nums1[k/2 - 1] < nums2[k/2 - 1], do the same way.
	 * 
	 * Return the Median of these two sorted array
	 * 
	 * Time: O(log(Median)) Space: O(log(Median))
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int length = nums1.length + nums2.length;
		if(length % 2 != 0){
			if(nums1.length > nums2.length){
				return findMedian(nums1, 0, nums2, 0, (length + 1) / 2);
			}
			return findMedian(nums2, 0, nums1, 0, (length + 1) / 2);
		} else {
			if(nums1.length > nums2.length){
				return (findMedian(nums1, 0, nums2, 0, (length) / 2) + findMedian(nums1, 0, nums2, 0, (length / 2) + 1)) / 2.0;   
			}
			return (findMedian(nums2, 0, nums1, 0, (length) / 2) + findMedian(nums2, 0, nums1, 0, (length / 2) + 1)) / 2.0;  
		}      
	}

	private static int findMedian(int[] nums1, int start1, int[] nums2, int start2, int median){
		if(start1 >= nums1.length){
			return nums2[start2 + median - 1];
		}
		else if(start2 >= nums2.length){
			return nums1[start1 + median - 1];
		}
		if(median == 1){
			return Math.min(nums1[start1], nums2[start2]);
		}
		int median1 = start1 + median / 2 - 1 < nums1.length ? nums1[start1 + median / 2 - 1] : Integer.MAX_VALUE;
		int median2 = start2 + median / 2 - 1 < nums2.length ? nums2[start2 + median / 2 - 1] : Integer.MAX_VALUE;
		if(median1 < median2 || median1 == Integer.MAX_VALUE){
			return findMedian(nums1, start1 + median / 2, nums2, start2, median - median / 2);

		}
		return findMedian(nums1, start1, nums2, start2 + median / 2, median - median / 2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {2, 3, 4, 5, 6};
		int[] nums2 = {1};
		System.out.print(findMedianSortedArrays(nums1, nums2));
		System.exit(0);

	}

}
