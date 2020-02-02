package linkedlist;

public class AddTwoNumbers {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) {
        	return l2;
        }
        
        if(l2 == null) {
        	return l1;
        }
        
        ListNode node = null;
        ListNode head = null;
        int r = 0;
        while(l1 != null || l2 != null) {
        	int sum = (l1 != null) ? l1.val : 0;
        	sum = sum  + ((l2 != null) ? l2.val : 0) + r;
        	
        	r = 0;
        	if(sum > 9) {
        		sum = sum - 10;
        		r = 1;
        	}
        	
        	if(node == null) {
        		node = new ListNode(sum);
        		head = node;
        	}
        	else {
        		node.next = new ListNode(sum);
        		node = node.next;
        	}
        	
        	if(l1 != null)
        		l1 = l1.next;
        	if(l2 != null)
        		l2 = l2.next;
        }
        
        if(r != 0) {
        	node.next = new ListNode(r);
        }
        
        return head;
    }
	
	public static class ListNode {
      public int val;
      public ListNode next;
      public ListNode(int x) { val = x; }
	}
	
	public static void printList(ListNode head) {
		ListNode node = head;
		while(node != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		System.out.print("NULL");
	}
	
	public static void main(String[] args) {
		AddTwoNumbers sol = new AddTwoNumbers();
		ListNode l1 = new ListNode(5);
		/*
		 * l1.next = new ListNode(4); l1.next.next = new ListNode(3); l1.next.next.next
		 * = new ListNode(1);
		 */
		
		printList(l1);
		
		System.out.println();
		
		ListNode l2 = new ListNode(5);
		/*
		 * l2.next = new ListNode(6); l2.next.next = new ListNode(4);
		 */
		
		printList(l2);
		
		System.out.println();
		
		ListNode head = sol.addTwoNumbers(l1, l2);
		
		printList(head);
	}
}
