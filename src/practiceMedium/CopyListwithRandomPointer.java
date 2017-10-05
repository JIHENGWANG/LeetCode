package practiceMedium;




class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { this.label = x; }
}
public class CopyListwithRandomPointer {

	/*
	 * Assumptions: 
	 * if head is null, then return null;
	 * 
	 * 
	 * Steps:
	 * 		1. copy head.val and head.ramdone if they are not null
	 * 		2. curr = curr.next;
	 * 		3. head = head.next;
	 * 
	 * Return a new list or null
	 * 
	 * Time: o(n), space: o(n)
	 */
	
	public static RandomListNode copyRandomList(RandomListNode head) {
		if(head == null){
			return null;
		}
		RandomListNode sol = new RandomListNode(0);
		RandomListNode curr = sol;
		while(head != null){
			curr.next = new RandomListNode(head.label);
			curr = curr.next;
			if(head.random != null){
				curr.random = new RandomListNode(head.random.label);
			}
			head = head.next;
		}
		return sol.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
