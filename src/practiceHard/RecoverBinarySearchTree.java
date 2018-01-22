package practiceHard;

import java.util.LinkedList;



public class RecoverBinarySearchTree {

	/*
	 * if root is null. then return void,
	 * 
	 * Steps: use inoder treversal to treverse the whole tree,
	 * 		  and create two local to save the previous node and current node.
	 * 
	 * Time: o(n), Space o(1)
	 */
	public void recoverTree(TreeNode root) {
        if(root == null){
        	return;
        }
        TreeNode curr = root; TreeNode pre = null, first = null, second = null;
        LinkedList<TreeNode> stack = new LinkedList<> ();
        while(curr != null || !stack.isEmpty()){
        	if(curr != null){
        		stack.push(curr);
        		curr = curr.left;
        	} else {
        		TreeNode temp = stack.pop();
        		curr = temp;
        		if(pre == null){
        			pre = curr;
        		} else if(pre.val > curr.val){
        			if(first == null){
        				first = pre;
        				second = curr;
        			}
        			else {
        				second = curr;
        			}
        		}
        		pre = curr;
        		curr = curr.right;
        	}
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
