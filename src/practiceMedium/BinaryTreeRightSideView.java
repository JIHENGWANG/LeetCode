package practiceMedium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

	/*
	 * If root is null, return null; 
	 * Traverse each level of tree from right to left ,and
	 * add the first element of the queue into list.
	 * 
	 * Time: o(n). Space: o(logn)
	 */
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> sol = new ArrayList<> ();
		if(root == null){
			return sol;
		}
		Queue<TreeNode> q = new LinkedList<> ();
		q.offer(root);
		while(!q.isEmpty()){
			int size = q.size();
			sol.add(q.peek().val);
			for(int i = 0; i < size; i++){
				TreeNode curr = q.poll();
				if(curr.right != null){
					q.offer(curr.right);
				}
				if(curr.left != null){
					q.offer(curr.left);
				}
			}
		}
		return sol;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
