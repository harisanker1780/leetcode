package linkedlist;

public class PalindromeLinkedList {
	
	public boolean isPalindrome(ListNode head) {
		
		if(head == null) {
			return true;
		}
		
        int length = calculateLength(head);
        int mid = (length / 2);
        int index = 1;
        ListNode node = head;
        ListNode prev = null;
        while(index <= mid) {
        	ListNode next = node.next;
        	node.next = prev;
        	prev = node;
        	node = next;
        	index++;
        }
        
        while(index < (length - mid) + 1) {
        	node = node.next;
        	index++;
        }
        
        ListNode node1 = prev;
        ListNode node2 = node;
        
        while(node1 != null && node2 != null) {
        	if(node1.val != node2.val) {
        		return false;
        	}
        	
        	node1 = node1.next;
        	node2 = node2.next;
        }
        
        return true;
    }
	
	private int calculateLength(ListNode head) {
		int length = 0;
		while(head != null) {
			head = head.next;
			length++;
		}
		return length;
	}
	
	public static class ListNode {
	      public int val;
	      public ListNode next;
	      public ListNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		PalindromeLinkedList sol = new PalindromeLinkedList();
		
		ListNode head = new ListNode(1);
		/*
		 * head.next = new ListNode(2); head.next.next = new ListNode(3);
		 * head.next.next.next = new ListNode(2); head.next.next.next.next = new
		 * ListNode(1); head.next.next.next.next.next = new ListNode(1);
		 */
		
		System.out.println(sol.isPalindrome(head));
	}
}
