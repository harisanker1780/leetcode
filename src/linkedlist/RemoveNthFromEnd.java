package linkedlist;

public class RemoveNthFromEnd {
	
	public ListNode RemoveNthFromEnd(ListNode head, int n) {
    
		int length = 0;
		ListNode node = head;
		while(node != null) {
			node = node.next;
			length++;
		}
		
		int pos = length - n;
		node = head;
		ListNode prev = head;
		while(pos > 0) {
			prev = node;
			node = node.next;
			pos--;
		}
		
		if(node != null) {
			if(node == head) {
				return node.next;
			}
			else {
				prev.next = node.next;
			}
		}
		
		return head;
    }

	class ListNode {
      public int val;
      public ListNode next;
      public ListNode(int x) { val = x; }
	}

}


