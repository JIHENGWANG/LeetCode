package practiceMedium;

public class RemoveNthNodeFromEndofList {
	/*
	 * Assumptions: 
	 * If head = null, then return head;
	 * if head.next == null and n = 1, return null;
	 * 
	 * Steps:
	 * 		need a dummy node 
	 * 		Keep maintaining a slow and fast pointer.
	 * 		  1. let fast pointer move n steps.
	 * 			 if (fast == null) return head;
	 * 	      2. move slow and fast, when fast == null, delete slow.next pointer.
	 * 
	 * Return a list without nth node from end.
	 * 
	 * Time: o(n), Space: o(1).
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null){
        	return head;
        }
        if(head.next == null && n == 1){
            return null;
        }
        ListNode dummy = new ListNode (0);
        dummy.next = head;
        ListNode fast = dummy;
        for(int i = 0; i < n; i++){
        	if(fast.next == null){
        		return head;
        	} else {
        		fast = fast.next;
        	}
        }
        ListNode slow = dummy;
        while(fast.next != null){
        	slow = slow.next;
        	fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
