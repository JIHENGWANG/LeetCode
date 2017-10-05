package practiceMedium;

public class findCycleNode {
	/*
	 * Assumptions:
	 * 1. head == null || head.next == null, return null
	 * 
	 * Steps:
	 * 		1, run slow and fast node on list, if they meet together,
	 * 		   then cycle exist, otherwise return null.
	 * 		2. run slow and fast again but slow from head and fast from
	 * 		   current position, if they meet again, that's the cycle node
	 * 		   ,return it.
	 * 		
	 * 		(notes) Suppose length of list execept cycle is X, the length of cycle is Y
	 * 		        then steps of slow = X + nY  steps of fast = X + mY
	 * 				2 * (steps of slow) = steps of fast
	 * 				2X + 2nY = X + mY
	 * 				X = (m - 2n)Y Means slow only need to move X steps, then we found the 
	 * 			    cycle node.
	 * 
	 * Return the cycle node
	 * 
	 * Time: o(n). Space: o(1)
	 * 				
	 */
	public ListNode detectCycle(ListNode head) {
		if(head == null || head.next == null){
			return null;
		}
		boolean isCycle = false;
		ListNode slow = head;
		ListNode fast = head;
		while(slow != null && fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				isCycle = true;
				break;
			}
		}
		if(!isCycle){
			return null;
		}
		slow = head;
		while(slow != null && fast != null){
			slow = slow.next;
			fast = fast.next;
			if(slow == fast){
				return slow;
			}
		}
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
