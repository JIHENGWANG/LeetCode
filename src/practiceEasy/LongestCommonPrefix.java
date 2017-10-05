package practiceEasy;

import java.util.Arrays;
import java.util.Comparator;

public class LongestCommonPrefix {
	
	/*
	 * Assumptions:
	 * Case 1: if the array of strings are null or empty, then return null.
	 * 
	 * Steps: sort the whole array, and let the first element of array be the prefix.
	 * 	      take out last characters from prefix if found the prefix is not the substring of next 
	 * 		  string in array.
	 * 
	 * Return empty string if prefix is empty, return prefix otherwise.
	 * 
	 * Time Complexity: o(nlogn) + o(s)(the total characters of array of string)
	 */
	
	public static String longestCommonPrefix(String[] strs) {
		/*Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String one, String two){
				if(one.length() == two.length()){
					return 0;
				}
				return one.length() < two.length() ? 1 : -1;
			}
		});
		String prefix = strs[0];
		for(String st : strs){
			if(st == "" || prefix.isEmpty()){
				return "";
			}
			else if(st.indexOf(prefix) != 0){
				prefix = prefix.substring(0, prefix.length() - 1);
			}
			
		}
        return prefix;*/
	    if(strs == null || strs.length == 0)    return "";
	    String pre = strs[0];
	    int i = 1;
	    while(i < strs.length){
	        while(strs[i].indexOf(pre) != 0)
	            pre = pre.substring(0,pre.length()-1);
	        i++;
	    }
	    return pre;
	   
    }
	 public int[] fuck(int wa){
	    	return new int[] {};
	 }
	 
	public static int maxIndexDiff(int arr[]) {
		int min = Integer.MAX_VALUE;
		int max = -1;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] < min){
				min = arr[i];
			} else if(arr[i] - min > max) {
				max = arr[i] - min;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leetcode";
		
		String[] a = {"abab","aba",""};
		
		int[] prefix = {3, 4, 7, 2, 5};
		System.out.print(maxIndexDiff(prefix));
		System.exit(0);
	}

}
