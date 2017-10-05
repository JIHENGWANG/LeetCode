package practiceMedium;



public class SortList {
	/*
	 * Assumptions:
	 * 1.head is null or there is only one node in head, then return head;
	 * 
	 * Steps:  Using merge sort.
	 * 		   1. Find the middle of list, break to half, use the 
	 * 			  merge sort algorithm to sort the first half and 
	 * 			  second half, and then sort them togeter.
	 */
	public static ListNode sortList(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		return mergeSort(head, null);
	}


	private static ListNode mergeSort(ListNode head, ListNode tail){
		if(head == null || head.next == null){
			return head;
		}
		ListNode middle = findMiddle(head);
		ListNode next = middle.next;
		middle.next = null;
		ListNode left = mergeSort(head, middle);
		ListNode right = mergeSort(next, tail);
		return merge(left, right);

	}

	private static ListNode merge(ListNode l1, ListNode l2){
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
	
	private static ListNode findMiddle(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode test = new ListNode(0);
		ListNode curr = test;
		curr.next = new ListNode(4);
		curr = curr.next;
		curr.next = new ListNode(6);
		curr = curr.next;
		curr.next = new ListNode(7);
		curr = curr.next;
		curr.next = new ListNode(3);
		curr = curr.next;
		curr.next = new ListNode(2);
		curr = curr.next;
		curr.next = new ListNode(5);
		curr = curr.next;
		curr.next = new ListNode(9);
		curr = curr.next;
		curr.next = new ListNode(10);
		curr = curr.next;
		curr.next = new ListNode(19);
		curr = curr.next;
		//System.out.print(findMiddle(test).val);
		sortList(test);
		while(test != null){
			System.out.print(test.val + " ");
			test = test.next;
		}

	}

}
