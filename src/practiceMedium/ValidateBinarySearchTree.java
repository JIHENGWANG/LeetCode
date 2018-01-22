package practiceMedium;

public class ValidateBinarySearchTree {

	/*
	 * time: o(n), spaece o(logn)
	 */
	public boolean isValidBST(TreeNode root) {
        if(root == null){
        	return true;
        }
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
	private boolean helper(TreeNode root, int min, int max){
		if(root == null){
			return true;
		}
		if(root.val >= max || root.val <= min){
			return false;
		}
		return helper(root.left, min, root.val) && helper(root.right, root.val, max);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
