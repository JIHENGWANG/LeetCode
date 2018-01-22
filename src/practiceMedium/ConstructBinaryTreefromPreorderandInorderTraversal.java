package practiceMedium;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	/*
	 * if any array of order is null or empty, return null;
	 * steps: use the preorder to build the root on current level,
	 * 		  use the inorder to determine the left and right subtree. until
	 * 		  all elements are used.
	 * 
	 * Trick: Set boundary of preorder preLeft and preRight;
	 * 	 					  inorder inLeft and inRight;
	 * 		  The first element of the preorder will be root of current subtree,
	 * 		  find how many element in the left subTree using map.get<root.val> - the left
	 * 		  boundary of inorder. 
	 * 		  Boundary in left sub tree: preLeft + 1, inLeft, preLeft + leftSize, inLeft + leftSize - 1
	 * 		  Boundary in right sub Tree: preLeft + leftSize + 1, inLeft + leftSize + 1, preRight, inRight
	 * 
	 * Time: o(n) Space: o(n + logn)
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null ||
        		preorder.length == 0 || inorder.length == 0){
        	return null;
        }
        Map<Integer, Integer> map = buildMap(inorder);
        int preLength = preorder.length - 1;
        int inLength = inorder.length - 1;
        return build(preorder, inorder, 0, 0, preLength, inLength, map);
    }
	
	private static TreeNode build(int[] pre, int[] in, int preLeft, int inLeft, int preRight, int inRight, 
			Map<Integer, Integer> map){
		if(inLeft > inRight){
			return null;
		}
		TreeNode root = new TreeNode (pre[preLeft]);
		int leftSize = map.get(root.val) - inLeft;
		root.left = build(pre, in, preLeft + 1, inLeft, preLeft + leftSize, inLeft + leftSize - 1, map);
		root.right = build(pre, in, preLeft + leftSize + 1, inLeft + leftSize + 1, preRight, inRight, map);
		return root;
	}
	
	private static Map<Integer, Integer> buildMap(int[] array){
		Map<Integer, Integer> hashMap = new HashMap<> ();
		for(int i = 0; i < array.length; i++){
			Integer pos = hashMap.get(array[i]);
			if(pos == null){
				hashMap.put(array[i], i);
			}
		}
		return hashMap;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
