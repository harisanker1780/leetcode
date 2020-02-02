package linkedlist;

public class OddEvenLinkedList {
	
	public ListNode oddEvenList(ListNode head) {
		int index = 1;
		ListNode node = head;
		ListNode oddHead = null;
		ListNode evenHead = null;
		ListNode oddList = null;
		ListNode evenList = null;
		while(node != null) {
			ListNode next = node.next;
			if(index % 2 == 0) {
				// Even
				if(evenList == null) {
					evenList = node;
					evenHead = node;
				}
				else {
					evenList.next = node;
					evenList = node;
				}
				evenList.next = null;
			}
			else {
				// Odd
				if(oddList == null) {
					oddList = node;
					oddHead = node;
				}
				else {
					oddList.next = node;
					oddList = node;
				}
				oddList.next = null;
			}
			
			index++;
			node = next;
		}
		
		if(oddList != null) {
			oddList.next = evenHead;
		}
		
		return oddHead;
    }
	
	public static class ListNode {
	      public int val;
	      public ListNode next;
	      public ListNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		OddEvenLinkedList sol = new OddEvenLinkedList();
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		printList(head);
		System.out.println();
		
		head = sol.oddEvenList(head);
		
		printList(head);
	}
	
	public static void printList(ListNode head) {
		ListNode node = head;
		while(node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		System.out.print("NULL");
	}
}
