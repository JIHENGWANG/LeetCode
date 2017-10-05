package practiceEasy;

public class RemoveDuplicatesfromSortedList {
	/*
	 * Same way as we did in array
	 */
	public static ListNode removeDup(ListNode head) {
	    //Input your code here
		if(head == null || head.next == null){
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null){
			if(slow.val != fast.val){
				slow = slow.next;
				slow.val = fast.val;
				//slow = slow.next;
			}
			fast = fast.next;
		}
		slow.next = null;
	    return head;
	 }
	public static void buildNode(ListNode one){
		ListNode curr = one;
		for(int i = 0; i < 11; i += 2){
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
