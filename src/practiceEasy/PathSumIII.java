package practiceEasy;

import java.util.ArrayList;
import java.util.List;

public class PathSumIII {
	int count;
	public int pathSum(TreeNode root, int sum) {
        if(root == null){
        	return 0;
        }
        List<Integer> sol = new ArrayList<> ();
        findSum(root, sum, sol);
        return count;
    }
	private void findSum(TreeNode root, int sum, List<Integer> sol){
		if(root == null){
			return;
		}
        sol.add(root.val);
        count(sol, sum);
		if(root.left != null){
			findSum(root.left, sum, sol);
		}
		if(root.right != null){
			findSum(root.right, sum, sol);
		}
		sol.remove(sol.size() - 1);
	}
	private void count(List<Integer> sol, int val){
		int sum = 0;
		for(int i = sol.size() - 1; i >= 0; i--){
			sum += sol.get(i);
			if(sum == val){
			  return;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
