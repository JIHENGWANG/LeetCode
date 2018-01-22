package practiceMedium;

public class PopulatingNextRightPointersinEachNodeII {

	public void connect(TreeLinkNode root) {
		if(root == null){
        	return;
        }
		while (root != null) {
			TreeLinkNode dummy = new TreeLinkNode(0);
			TreeLinkNode curr = dummy;
			TreeLinkNode level = root;
			while (level != null) {
				if (level.left != null) {
					curr.next = level.left;
					curr = curr.next;
				}
				if (level.right != null) {
					curr.next = level.right;
					curr = curr.next;
				}
				level = level.next;
			}
			root = dummy.next;
		}
    }
	
	public void connectRecursion(TreeLinkNode root) {
		if (root == null){
			return;
		}
		TreeLinkNode dummy = new TreeLinkNode(0);
		TreeLinkNode curr = dummy;
		while (root != null) {
			if (root.left != null) {
				curr.next = root.left;
				curr = curr.next;
			}
			if (root.right != null) {
				curr.next = root.right;
				curr = curr.next;
			}
			root = root.next;
		}
		connectRecursion(dummy.next);

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
