package practiceEasy;
import java.util.*;
public class ReverseLinkedList {
	/*
	 * Assumptions:
	 * If head is null or head.next is null, then return head
	 * 
	 * Steps: while curr != null, we save curr.next to next, and curr.next points to pre.
	 * 		  pre move to curr, curr move to next 
	 * 
	 * Return pre to be the new head of the list
	 * 
	 * Time: o(n), space: o(n)
	 */
	public static ListNode reverseList(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode curr = head;
		ListNode pre = null;
		while(curr != null){
			ListNode next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}
		return pre;
	}
	
	
	/*
	 * reverse list in recursive way
	 * 
	 * Steps: save head.next to next, and keep calling function on head.next 
	 * 		  until a head.next == null is reached, and then return the newHead.
	 * 		  let head.next = null, change the pointing direction on next, which is 
	 * 		  next.next = head.
	 * 
	 * Return the newHead
	 * 
	 * Time: o(n), space: o(n)
	 */
	
	public static ListNode reverseListRecursive(ListNode head) {
		if(head == null|| head.next == null){
			return head;
		}
		ListNode next = head.next;
		ListNode newHead = reverseListRecursive(next);
		head.next = null;
		next.next = head;
		return newHead;
	}
	
	
	
	
	public static void buildNode(ListNode one, ListNode two){
		ListNode curr = one;
		for(int i = 0; i < 11; i += 2){
			curr.next = new ListNode(i);
			curr = curr.next;
		}
		ListNode cur = two;
		for(int i = 1; i < 12; i += 2){
			cur.next = new ListNode(i);
			cur = cur.next;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode one = new ListNode(0);
		ListNode two = new ListNode(0);
		buildNode(one, two);
		ListNode sol = reverseListRecursive(two);
		while(sol != null){
			System.out.print(sol.val + " ");
			sol = sol.next;
		}
		
		System.exit(0);

	}
}
