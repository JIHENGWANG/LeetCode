package practiceMedium;



public class RemoveExtraDuplicatesfromSortedList {
	/*
	 * almost same as we did in remove all elements have duplicate in array
	 * can remove all same elements first if head.val == head.next.val
	 */
	public static ListNode removeDup(ListNode head) {
	    //Input your code here
		if(head == null || head.next == null){
			return head;
		}
		ListNode dummy = new ListNode(0), fast = head, slow = dummy;
	    slow.next = fast;
	    while(fast != null) {
	    	while (fast.next != null && fast.val == fast.next.val) {
	     		fast = fast.next;    //while loop to find the last node of the dups.
	    	}
	    	if (slow.next != fast) { //duplicates detected.
	    		slow.next = fast.next; //remove the dups.
	    		fast = slow.next;     //reposition the fast pointer.
	    	} else { //no dup, move down both pointer.
	    		slow = slow.next;
	    		fast = fast.next;
	    	}
	    	
	    }
	    return dummy.next;
	}
	public static void buildNode(ListNode one){
		ListNode curr = one;
		for(int i = 1; i < 10; i++){
			curr.next = new ListNode(i);
			curr = curr.next;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode one = new ListNode (0);
		buildNode(one);
		one = removeDup(one);
		while(one != null){
			System.out.print(one.val + " ");
			one = one.next;
		}
	}

}
