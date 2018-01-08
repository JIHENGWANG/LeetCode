package practiceEasy;

public class isBalancedTree {

	/*
	 * check if the diff in left height and diff in right height is greater then 1,
	 * if it is, then return -1.
	 * 
	 * Time: o(n), space: o(logn)
	 */
	public boolean isBalanced(TreeNode root) {
		if(root == null){
			return true;
		}
		return heightDiff(root) != -1;
    }
	private int heightDiff(TreeNode root){
		if(root == null){
			return 0;
		}
		int left = heightDiff(root.left);
		int right = heightDiff(root.right);
		if(left == -1 || right == -1 || Math.abs(left - right) > 1){
			return -1;
		}
		return Math.max(left, right) + 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
