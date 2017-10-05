package practiceEasy;
import java.util.*;
public class IntersectionofTwoLinkedLists {
	/*
	 * Assumptions: 
	 * if one of them is null, then return false;
	 * 
	 * Steps:
	 * 		1. find the length of two node, if length of A is longer, then move
	 * 		   A until the length of A is equal to length of B.
	 * 		   if length B is longer, do the same way of B.
	 *      2. move A and B, if A == B, then return A. else keep moving until A and B
	 *         are all null.
	 * 
	 * return the node of intersection, otherwise return null.
	 * 
	 * time: o(m + n). 
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if( headA == null || headB == null){
			return null;
		}
		int lengthA = getLength(headA);
		int lengthB = getLength(headB);
		if (lengthA > lengthB){
			int n = 0;
			while(n < lengthA - lengthB){
				headA = headA.next;
				n++;
			}
		} else if(lengthB > lengthA){
			int n = 0;
			while(n < lengthB - lengthA){
				headB = headB.next;
				n++;
			}
		}
		while(headA != null && headB != null){
			if(headA != headB){
				headA = headA.next;
				headB = headB.next;
			} else {
				return headA;
			}
		}
		return null;
	}
	static int getLength(ListNode head){
		int count = 0;
		while(head != null){
			count++;
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
