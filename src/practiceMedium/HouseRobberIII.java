package practiceMedium;

public class HouseRobberIII {
	
	/*
	 * if root == null, then return 0;
	 * Steps: DP algorithm using on a recursion. create an array that has two elements
	 * 		  the first one represent the maximum value if we don't rob the current root,
	 * 		  the second one represent the maximum value if we rob the current root. 
	 * 
	 */
	public int rob(TreeNode root) {
	    int[] res = robSub(root);
	    return Math.max(res[0], res[1]);
	}

	private int[] robSub(TreeNode root) {
	    if (root == null) return new int[2];
	    
	    int[] left = robSub(root.left);
	    int[] right = robSub(root.right);
	    int[] res = new int[2];

	    res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
	    res[1] = root.val + left[0] + right[0];
	    
	    return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
