package practiceEasy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
	/*
	 * if root is null, then return null
	 * 
	 * Steps: use dfs to explore every path in the tree until
	 *  	  we hit the leaf node, add the string to our list,
	 *  	  and delete all char in this level and return.
	 *  
	 *  Time: o(kn) Space: o(logn + n)
	 */
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> sol = new ArrayList<> ();
		if(root == null){
        	return sol;
        }
		StringBuilder paths = new StringBuilder();
		findPaths(root, sol, paths);
		return sol;
    }
	
	private void findPaths(TreeNode root, List<String> sol, StringBuilder paths){
		if(root.left == null && root.right == null){
            paths.append(root.val);
			sol.add(paths.toString());
           remove(paths, "" + root.val);
			return;
		}
		paths.append(root.val + "->");
		if(root.left != null){
			findPaths(root.left, sol, paths);
		}
		if(root.right != null){
			findPaths(root.right, sol, paths);
		}
        remove(paths, root.val + "->");
	}
    
    private void remove(StringBuilder b, String s){
        for(int i = 0; i < s.length(); i++){
           b.deleteCharAt(b.length() - 1);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
