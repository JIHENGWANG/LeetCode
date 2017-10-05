package practiceMedium;

public class OddEvenLinkedList {
	public ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null){
        	return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while(even != null && even.next != null){
        	odd.next = even.next;
        	odd = odd.next;
        	even.next = odd.next;
        	even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
