package practiceEasy;

public class PathSum {

	/*
	 * if root is null, then return null;
	 * 
	 * Steps: Use DFS to explore every path from the root to leaves. 
	 * 
	 * Time: o(n). Space: o(logn)
	 *        
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
        	return false;
        }
        return findSum(root, sum, 0);
    }
	private boolean findSum(TreeNode root, int sum, int val){
		if(root == null){
			return false;
		}
        if(root.val + val == sum && root.left == null && root.right == null){
			return true;
		}
		return findSum(root.left, sum, val + root.val) || findSum(root.right, sum, val + root.val);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
