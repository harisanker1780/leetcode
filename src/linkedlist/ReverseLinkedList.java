package linkedlist;

public class ReverseLinkedList {
	
	 public ListNode reverseList(ListNode head) {
		 ListNode node = head;
		 while(node != null) {
			 ListNode next = node.next; 
			 if(node != head) {
				 node.next = head;
				 head = node;
			 }
			 else {
				 head.next = null;
			 }
			 
			 node = next;
		 }
		 
		 return head;
	 }
	 
	 public static class ListNode {
	      public int val;
	      public ListNode next;
	      public ListNode(int x) { val = x; }
	 }
	 
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		printList(head);
		System.out.println();
		
		ReverseLinkedList sol = new ReverseLinkedList();
		head = sol.reverseList(head);
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
