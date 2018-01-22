package practiceMedium;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
	
	/*
	 * Assume that inorder and postorder represent the same tree.
	 * if any array is null or empty, then return null,
	 * 
	 * Steps: Use map to save all elements in inorder, where key will be the value
	 * 		  of each element, and value will be the index of each element.
	 * 		  the root in current subtree will be the last element of
	 * 		  postorder. count the how many elements in left subtree and right
	 * 		  subtree using inorder. 
	 * 
	 * Trick: set boundary of postorder: poLeft = 0, poRight = postorder.length - 1;
	 * 		  				  inorder: inLeft = 0, inright = inorder.length - 1;
	 *        every time when we create a new root, use map.get(root.val) - inleft to find
	 *        the total number of elements in left subtree. let's call it leftSize;
	 *        so root.left will use inLeft, inLeft + leftSize - 1, poLeft, poLeft + leftSize - 1;
	 *        	 root.right will use inLeft + leftSize + 1, inRight, poLeft + leftSize, poRight - 1;
	 *        
	 * Time: o(n) Space: o(n + logn)
	 */
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0 || postorder.length == 0){
        	return null;
        }
        Map<Integer, Integer> map = buildMap(inorder);
        return build(inorder, postorder, 0, 0, inorder.length - 1, postorder.length - 1, map);
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
	
	private static TreeNode build(int[] in, int [] po, int inLeft, int poLeft, int inRight, int poRight, 
			Map<Integer, Integer> map){
		if(inLeft > inRight){
			return null;
		}
		TreeNode root = new TreeNode (po[poRight]);
		int leftSize = map.get(root.val) - inLeft;
		root.left = build(in, po, inLeft, poLeft, inLeft + leftSize - 1, poLeft + leftSize - 1, map);
		root.right = build(in, po, inLeft + leftSize + 1, poLeft + leftSize, inRight, poRight - 1, map);
		return root;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
