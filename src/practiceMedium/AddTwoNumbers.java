package practiceMedium;



class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class AddTwoNumbers {
	/*
	 * Need temp1 and temp2 to save current val of node. 
	 * Need to create a sum to save the sum of temp1 + temp2.
	 * Need a carry to save the carry on number if sum larger than 10.
	 * Need to create a new linkedList to save each sum.
	 * 
	 * Steps:
	 *       1. ilterative each node in l1 and l2, temp1 = l1 == null ? 0 : l1.val, do the same way to temp2.
	 *       2. sum = temp1 + temp2. if sum >  10, carry++, sum = sum - 10.
	 *       3. save the sum to the new list. 
	 *       
	 * Return the head of new list
	 * 
	 * Time: o(n) Space: o(n)
	 * 
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sol = new ListNode(0);
        ListNode curr = sol;
        int carry = 0;
        while(l1 != null || l2 != null){
        	int add1 = l1 != null ? l1.val : 0;
        	int add2 = l2 != null ? l2.val : 0;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        	int sum = add1 + add2 + carry;
        	carry = sum / 10;
        	curr.next = new ListNode(sum % 10);
        	curr = curr.next;
        }
        curr.next = carry == 1 ? new ListNode(1) : null;
        return sol.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
