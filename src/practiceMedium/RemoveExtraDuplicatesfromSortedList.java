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
		ListNode fake = new ListNode (0);
		fake.next = head;
		ListNode slow = fake;
		ListNode pre = null;
		ListNode fast = head.next;
		while(fast != null){
			if(slow == fake || slow.val != fast.val){
				pre = slow;
				slow = slow.next;
				slow.val = fast.val;
			} else{
				while(fast.next != null && fast.next.val == slow.val){
					fast = fast.next;
				}
				slow = pre;
				slow.next = fast.next;
			}
			fast = fast.next;
		}
		
		//slow.next = null;
	    return fake.next;
	}
	public static void buildNode(ListNode one){
		ListNode curr = one;
		for(int i = 1; i < 10; i ++){
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
