package practiceMedium;



public class ConvertSortedListtoBinarySearchTree {
	/*
	 * Similar to the traverse inorder, but finding middle pointer costs linear time
	 * in each level.
	 * 
	 * Time: o(n) Space : o(logn)
	 */
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	static ListNode curr;

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		int length = count(head);
		curr = head;
		return buildTree(0, length - 1);
	}

	private static int count(ListNode head) {
		int length = 0;
		while (head != null) {
			length++;
			head = head.next;
		}
		return length;
	}

	private static TreeNode buildTree(int left, int right) {
		if (left > right) {
			return null;
		}
		int mid = left + (right - left) / 2;
		TreeNode leftNode = buildTree(left, mid - 1);
		TreeNode root = new TreeNode(curr.val);
		root.left = leftNode;
		curr = curr.next;
		root.right = buildTree(mid + 1, right);
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
