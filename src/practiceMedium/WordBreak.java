package practiceMedium;
import java.util.*;


public class WordBreak {
	/*
	 * Assumptions: 
	 * if s == null, return false;
	 * Steps:
	 * 		1, build a hash set for wordDict
	 * 		2. Use dynamic programming to fill a 1d array to find out
	 * 		   if the word can be break
	 * 		   dp[i] represent the 0 to ith word can be break or not.
	 * 
	 * 
	 * Induction Rule: 
	 * 				Base Case i = 0; dp[i] = true;
	 * 				when i = k; check if set contains the subtring of s
	 * 				from 0 to i, if it is, then dp[i] = true;
	 * 				else , from j = 0 and j < i; 
	 * 
	 * Return dp[length]
	 * 
	 * Time: o(n^2) Space: o(n)
	 */
	public boolean wordBreak(String s, List<String> wordDict) {
		if(s == null){
			return false;
		}
		Set<String> set = new HashSet<> (wordDict);
		boolean [] dp = new boolean[s.length() + 1];
		for(int i = 0; i <= s.length(); i++){
			if(set.contains(s.substring(0, i))){
				dp[i] =true;
			} else {
				for(int j = 0; j < i; j++){
					dp[i] = dp[i] || (dp[j] && set.contains(s.substring(j, i)));
				}
			}
		}
		return dp[s.length()];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((18- 6) % 4);
		System.exit(0);
	}

}
