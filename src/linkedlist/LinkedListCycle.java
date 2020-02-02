package linkedlist;

public class LinkedListCycle {
	
  public boolean hasCycle(ListNode head) {
     if(head == null)
    	 return false;
     
     ListNode p1 = head;
     ListNode p2 = head.next;
     
     while(p1 != null && p2 != null) {
    	 if(p1 == p2)
    		 return true;
    	 p1 = p1.next;
    	 if(p2.next == null)
    		 break;
    	 p2 = p2.next.next;
     }
     
     return false;
  }
	
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
   }

}
