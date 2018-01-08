package practiceEasy;

public class MaximumDepthofBinaryTree {

	public int maxDepth(TreeNode root) {
		// Write your solution here.
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
