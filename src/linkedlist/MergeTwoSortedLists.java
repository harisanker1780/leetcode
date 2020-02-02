package linkedlist;

public class MergeTwoSortedLists {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) { 
        	return l2;
        }
        
        if(l2 == null) {
        	return l1;
        }
        
        ListNode head;
        if(l1.val <= l2.val) {
        	head = l1;
        	l1 = l1.next;
        }
        else {
        	head = l2;
        	l2 = l2.next;
        }
        
        ListNode node = head;
        while(l1 != null || l2 != null) {
        	if(l1 == null) {
        		node.next = l2;
        		node = l2;
        		l2 = l2.next;
        	}
        	else if(l2 == null) {
        		node.next = l1;
        		node = l1;
        		l1 = l1.next;
        	}
        	else {
        		if(l1.val <= l2.val) {
        			node.next = l1;
            		node = l1;
            		l1 = l1.next;
        		}
        		else {
        			node.next = l2;
            		node = l2;
            		l2 = l2.next;
        		}
        	}
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
		MergeTwoSortedLists sol = new MergeTwoSortedLists();
		
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		
		printList(l1);
		
		System.out.println();
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
		printList(l2);
		
		System.out.println();
		
		ListNode head = sol.mergeTwoLists(l1, l2);
		
		printList(head);
	}
}
