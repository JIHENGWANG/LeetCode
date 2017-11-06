package practiceMedium;


public class ReverseLinkedListII {
	/*
	 * Assumptions:
	 * if head is null, return head;
	 * 
	 * Assume: 1 <= m <=n <= length
	 * 
	 * Steps: Maintain slow fast pointers
	 * 		  1. fast move n steps.
	 * 		  2. slow move m steps.
	 * 		  3. swap the value of each node.
	 * 
	 * Return new list
	 * 
	 * Time: o(n), Space:o(1)
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null){
        	return head;
        }
        ListNode dummy = new ListNode (0);
        dummy.next = head;
        ListNode curr = head;
        ListNode from = dummy;
        ListNode to = null;
        for(int i = 0; i < m - 1; i++){
        	from = curr;
        	curr = curr.next;
        }
        from.next = reverseList(curr, to, n - m);
        curr.next = to;
        return dummy.next;
    }
	
	public static ListNode reverseList(ListNode head, ListNode to, int range) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode curr = head;
		ListNode pre = null;
		int i = 0;
		while(curr != null && i < range){
			ListNode next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
			to = next;
			i++;
		}
		return pre;
	}
	
	private void swap(ListNode slow, ListNode fast){
		int temp = slow.val;
		slow.val = fast.val;
		fast.val = temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
