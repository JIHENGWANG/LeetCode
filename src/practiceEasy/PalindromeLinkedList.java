package practiceEasy;

public class PalindromeLinkedList {
	/*
	 * Assumptions: 
	 * If head is null or head.next == null, return true becuase only one node is Palindrome
	 * 
	 * Steps:
	 * 		1. Reverse the second half of list. 
	 * 		2. Compare each node in the list, if any node are not equal, then return false
	 * 		   else return true;
	 * 
	 * return true if list is Palindrome, otherwise return false.
	 * 
	 * Time: o(n), Space: o(1)
	 */
	public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
        	return true;
        }
        int length =  getLength(head);
        int index = 0;
        ListNode curr = head;
        while(index != length / 2){
        	index++;
        	curr = curr.next;
        }
        ListNode pre = reverseList(curr);
        curr.next = null;
        while(head != null && pre != null){
        	if(head.val != pre.val){
        		return false;
        	}
        	head = head.next;
        	pre = pre.next;
        }
        return true;
    }
	
	private static int getLength(ListNode head){
		int count = 0;
		while(head != null){
			count++;
			head = head.next;
		}
		return count;
	}
	
	private static ListNode reverseList(ListNode head) {
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
