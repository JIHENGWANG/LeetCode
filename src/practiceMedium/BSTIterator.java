package practiceMedium;

import java.util.LinkedList;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}
/*
 * Create a curr node always points to the current position of our bst
 * Create a stack to save the TreeNodes in pre-order.
 * 
 * If curr is not null or stack is not empty then the tree has the next.
 * use the in-order version to print the next smaller node
 */
public class BSTIterator {
	
	TreeNode curr = null;
	LinkedList<TreeNode> stack = null;
	public BSTIterator(TreeNode root) {
        curr = root;
        stack = new LinkedList<> ();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return curr != null || !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        while(curr != null){
        	stack.push(curr);
        	curr = curr.left;
        }
        TreeNode retVal = stack.pop();
        curr = retVal.right;
        return retVal.val;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
