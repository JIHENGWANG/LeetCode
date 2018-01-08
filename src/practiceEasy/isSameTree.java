package practiceEasy;

public class isSameTree {
	/*
	 * if either tree is null, return false;
	 * if all trees are null, return true;
	 * 
	 * steps: use dfs to explore and campare nodes of each tree on same level,
	 * 		  if any node is not equal, return false;
	 * 
	 * times: o(n). Space: o(logn)
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
        	return true;
        } else if(p == null || q == null || p.val != q.val){
        	return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
