package practiceMedium;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	
	/*
	 * Time: o(n), space: (logn)
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> sol = new ArrayList<> ();
		if (root == null){
        	return sol;
        }
		List<Integer> cases = new ArrayList<> ();
		findSum(root, sol, cases, sum, 0);
		return sol;
    }
	
	private void findSum(TreeNode root, List<List<Integer>> sol, List<Integer> cases, int sum, int val){
		if(root == null){
			return;
		}
		if(root.left == null && root.right == null && root.val + val == sum){
			cases.add(root.val);
			sol.add(new ArrayList<Integer>(cases));
			cases.remove(cases.size() - 1);
		}
		cases.add(root.val);
		if(root.left != null){
			findSum(root.left, sol, cases, sum, val + root.val);
		}
		if(root.right != null){
			findSum(root.right, sol, cases, sum, val + root.val);
		}
		cases.remove(cases.size() - 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
