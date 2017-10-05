package practiceEasy;
import java.util.*;
public class LinkedListCycle {
	
	/*
	 * Assumptions: if head is null || head.next == null, then return false;
	 * 
	 * Step: Create a slow and fast pointer. if a linkedlist, fast and slow will
	 * 		 see each other. otherwise slow and fast will become null
	 * 
	 * return true if slow == fast, otherwise return false;
	 * 
	 * Time: o(n). Space:o(1);
	 */
	public static boolean hasCycle(ListNode head) {
		if(head == null || head.next == null){
			return false;
		}
		ListNode slow = head;
		ListNode fast = head;
		while(slow != null && fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
