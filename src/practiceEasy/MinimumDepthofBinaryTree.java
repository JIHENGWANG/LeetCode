package practiceEasy;

public class MinimumDepthofBinaryTree {
	/*
	 * if root is null, return 0;
	 * 
	 * Use dfs to find the shortest path between root to its nearest path.
	 */
	public int minDepth(TreeNode root) {
        if(root == null){
        	return 0;
        }
        if(root.left == null) return minDepth(root.right) + 1;
		if(root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
       
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
