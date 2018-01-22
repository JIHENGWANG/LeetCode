package practiceMedium;

public class FlattenBinaryTreetoLinkedList {
	/*
	 * reversed preorder to solve this problem.
	 */
	TreeNode pre = null;
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right=pre;
        root.left=null;
        pre=root;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
