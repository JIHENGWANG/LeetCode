package practiceEasy;
import java.util.*;


class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}


public class MergeTwoSortedLists {
	/*
	 * Assumptions:
	 * Case 1: if both linkedlist is null, then reuturn null
	 * Case 2: if either one of them is null, then return the other one
	 * 
	 * Steps:
	 * 		Create a new listNode called sol, compare each two node on two input lists,
	 * 		the smaller one will connect to sol, and then smaller
	 * 		one goes to next node. if a list is reach its tail, then new listNode 
	 * 		connect the remaining part of the other one.
	 * 
	 * Return the listNode that we create.
	 * 
	 * Time Complexity: O(the total number of node from two input listNode) Space: same as Time Complexity.
	 */

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode sol = new ListNode(0);
		ListNode curr = sol;
		while(l1 != null && l2 != null){
			if(l1.val <= l2.val){
				curr.next = l1;
				l1 = l1.next;
			} else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		curr.next = l1 == null ? l2 : l1;
		return sol.next;
	}
	/*
	 * The recursive way of doing this problem
	 */
	public static ListNode mergeListsRecursion(ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
	
	/*
	 * Tasting function
	 */
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
		ListNode sol = mergeTwoLists(one, two);
		while(sol != null){
			System.out.print(sol.val + " ");
			sol = sol.next;
		}
		
		System.exit(0);

	}

}
