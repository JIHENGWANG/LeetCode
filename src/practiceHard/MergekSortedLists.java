package practiceHard;
import java.util.*;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
public class MergekSortedLists {
	
	/*
	 * Assum k lists are not empty.
	 * 
	 * Steps: Maintain a priority queue. 
	 * 		  1. keep pop node from pq until pq is empty
	 * 		  2. create a dummy node, connect elements from pq and
	 * 			 return dummy.next;
	 * 
	 * Return new sorted list
	 * 
	 * Time: naive merge one by one: o(k^2n)
	 * 		 binary reduction: o(kn * logk) space: o(nK)
	 * 		 our k - merge: o(n * k * logk) Space: o(k)
	 */
	public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(11, new Comparator<ListNode>(){
        	@Override
        	public int compare(ListNode one, ListNode two){
        		if(one.val == two.val){
        			return 0;
        		}
        		return one.val < two.val ? -1 : 1;
        	}
        });
        for(int i = 0; i < lists.length; i++){
        	if(lists[i] != null){
        		minHeap.offer(lists[i]);
        	}
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(!minHeap.isEmpty()){
        	ListNode temp = minHeap.poll();
        	curr.next = temp;
        	if(temp.next != null){
        		minHeap.offer(temp.next);
        	}
        	curr = curr.next;
        }
        return dummy.next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
