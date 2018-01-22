package practiceMedium;

 class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}
public class PopulatingNextRightPointersinEachNode {
	/*
	 * if root is null, then return void,
	 * Steps: traverse the tree layer by layer. 
	 * 
	 * Time: o(n), Space: o(logn)
	 */
	/*public void connect(TreeLinkNode root) {
        if(root == null){
        	return;
        }
        TreeLinkNode pre = root;
        TreeLinkNode curr = null;
        while(pre.left != null){
        	curr = pre;
        	while(curr != null){
        		if(curr.right != null){
        			curr.left.next = curr.right;
        		}
        		if(curr.next != null){
        			curr.right.next = curr.next.left;
        		}
                curr = curr.next;
        	}
        	pre = pre.left;
        }
    }*/
	public void connect(TreeLinkNode root){
		if(root == null || root.left == null){
			return;
		}
		TreeLinkNode dummy = new TreeLinkNode(0);
        TreeLinkNode curr = dummy;
		while(root != null){
    		curr.next = root.left;
            curr = curr.next;
    		curr.next = root.right;
            curr = curr.next;
            root = root.next;
		}
		connect(dummy.next);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
