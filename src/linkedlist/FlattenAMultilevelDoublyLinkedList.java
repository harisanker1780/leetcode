package linkedlist;

public class FlattenAMultilevelDoublyLinkedList {
	
	
	public Node flatten(Node head) {
		if(head == null)
			return null;
		
		Node node = flattenUtil(head);
		Node prev = null;
		while(node != null) {
			if(prev != null) {
				node.prev = prev;
			}
			node.child = null;
			prev = node;
			node = node.next;
		}
		
		return head;
    }
	
	private Node flattenUtil(Node head) {
		if(head == null)
			return null;
		
		Node node = head;
		while(node.child == null && node.next != null) {
			node = node.next;
		}
		
		Node next = node.next;
		
		node.next = flattenUtil(node.child);
		
		while(node.next != null) {
			node = node.next;
		}
		
		node.next = flattenUtil(next);
		
		return head;
	}
	
	public static void main(String[] args) {
		
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		/*
		 * head.next.next.next.next = new Node(5); head.next.next.next.next.next = new
		 * Node(6);
		 */
		
		/*
		 * head.next.next.child = new Node(7); head.next.next.child.next = new Node(8);
		 * head.next.next.child.next.next = new Node(9);
		 * head.next.next.child.next.next.next = new Node(10);
		 * 
		 * head.next.next.child.next.child = new Node(11);
		 * head.next.next.child.next.child.next = new Node(12);
		 * head.next.next.child.next.child.next.child = new Node(13);
		 */
		
		head.next.child = new Node(6);
		head.next.child.next = new Node(7);
		head.next.next.child = new Node(5);
		
		FlattenAMultilevelDoublyLinkedList sol = new FlattenAMultilevelDoublyLinkedList();
		head = sol.flatten(head);
		
		Node n = head;
		while(n != null) {
			System.out.print(n.val + "->");
			n = n.next;
		}
		
	}

}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}
    
    public Node(int _val) {
    	this.val = _val;
    }

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
