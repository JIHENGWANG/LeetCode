package practiceEasy;

public class DeleteNode {
	
	/*
	 * Assumptions:
	 * If head == null. then return head.
	 * 
	 * Steps: 
	 * 		1. iterate each elements in list, and use pre and curr
	 * 		   mark the current postions and previous position. 
	 * 		2. if found the elements that we want to remove,
	 * 		   pre.next = curr.next; curr = pre.next;
	 * 
	 * Return the head of list
	 * 
	 * Time: o(n) space: o(1)
	 */
	public ListNode removeElements(ListNode head, int val) {
        if(head == null){
        	return head;
        }
        while(head != null && head.val == val){
        	head = head.next;
        }
        ListNode curr = head;
        ListNode pre = null;
        while(curr != null){
        	if(curr.val == val){
        		pre.next = curr.next;
        		curr.next = null;
        		curr = pre.next;	
        	} else {
        		pre = curr;
        		curr = curr.next;
        	}
        }
        return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
