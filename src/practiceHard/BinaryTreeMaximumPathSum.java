package practiceHard;



class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}
public class BinaryTreeMaximumPathSum {

	public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        findMax(root, max);
        return max[0];
    }
	private int findMax(TreeNode root, int[] max){
		if (root == null) {
			return 0;
		}
		int left = Math.max(0, findMax(root.left, max));
		int right = Math.max(0, findMax(root.right, max));
		int find =  Math.max(left, right) + root.val;
		max[0] = Math.max(max[0], left + right + root.val);
		return find;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
