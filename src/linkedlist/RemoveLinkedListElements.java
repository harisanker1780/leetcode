package linkedlist;

public class RemoveLinkedListElements {
	
	public ListNode removeElements(ListNode head, int val) {
		ListNode node = head;
		ListNode prev = null;
		while(node != null) {
			if(node.val == val) {
				if(prev == null) {
					head = node.next;
					node = head;
					continue;
				}
				else {
					prev.next = node.next;
				}
			}
			else {
				prev = node;
			}
			node = node.next;
		}
		
		return head;
    }
	
	public static class ListNode {
	      public int val;
	      public ListNode next;
	      public ListNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		RemoveLinkedListElements sol = new RemoveLinkedListElements();
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		
		printList(head);
		
		System.out.println();
		
		head = sol.removeElements(head, 2);
		
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
