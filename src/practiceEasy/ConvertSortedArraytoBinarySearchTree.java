package practiceEasy;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class ConvertSortedArraytoBinarySearchTree {
	/*
	 * if nums is null or empty, then return null,
	 * 
	 * Steps: in order to build a balanced tree, we must let the 
	 * 		  mid of array to be the root of tree, and find the mid from 
	 * 		  left and right, and repeat the step until all elements are
	 * 		  used
	 * 
	 * Time: o(n) Space: log(n)
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
       if(nums == null || nums.length == 0){
    	   return null;
       }
       return buildTree(nums, 0, nums.length - 1);
    }
	private TreeNode buildTree(int[] nums, int left, int right){
		if(left > right){
			return null;
		}
		int mid =  left + (right - left) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = buildTree(nums, left, mid - 1);
		root.right = buildTree(nums, mid + 1, right);
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
