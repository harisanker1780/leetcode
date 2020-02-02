package recursion;

/**
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.


Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * @author haris
 *
 */
public class SwapNodesInPairs {

	public ListNode swapPairs(ListNode head) {
		if(head == null)
			return null;
		
		if(head.next == null)
			return head;
		
		ListNode next = head.next;
		ListNode  temp = next.next;
		next.next = head;
		head.next = swapPairs(temp);
		return next;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
//		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
//		head.next.next.next.next.next = new ListNode(6);
		
		SwapNodesInPairs sol = new SwapNodesInPairs();
		head = sol.swapPairs(head);
		
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}



class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
 