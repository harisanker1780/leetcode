package linkedlist;

public class MyLinkedList {
	
	private Node head;

	/** Initialize your data structure here. */
    public MyLinkedList() {
        
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node n = head;
        while(n != null && index > 0) {
        	n = n.next;
        	index--;
        }
        
        return (n != null && index == 0) ? n.value : -1;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if(head == null) {
        	head = new Node(val);
        }
        else {
        	Node cur = new Node(val);
        	cur.next = head;
        	head = cur;
        }
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(head == null) {
        	head = new Node(val);
        }
        else {
        	Node cur = new Node(val);
        	Node tail = head;
        	while(tail.next != null) {
        		tail = tail.next;
        	}
        	
        	tail.next = cur;
        }
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
    	
    	if(index < 0) {
    		index = 0;
    	}
    	
        if(index == 0) {
        	addAtHead(val);
        }
        else {
        	Node n = head;
        	Node prev = null;
        	while(n != null && index > 0) {
        		prev = n;
        		n = n.next;
        		index--;
        	}
        	
        	if(prev != null && index == 0) {
        		Node cur = new Node(val);
        		cur.next = prev.next;
        		prev.next = cur;
        	}
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
    	
    	if(index < 0) {
    		index = 0;
    	}
    	
        Node n = head;
        Node prev = null;
        while(n != null && index > 0) {
        	prev = n;
        	n = n.next;
        	index--;
        }
        
        if(n != null) {
        	if(n == head) {
        		head = n.next;
        	}
        	else {
        		prev.next = n.next;
        		n.next = null;
        	}
        }
    }
    
    class Node {
    	int value;
    	Node next;
    	
    	public Node(int value) {
    		this.value = value;
    	}
    }
    
    public static void main(String[] args) {
    	MyLinkedList linkedList = new MyLinkedList();
    	linkedList.addAtHead(1);
    	linkedList.addAtTail(3);
    	linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
    	System.out.println(linkedList.get(-1));            // returns 2
    	linkedList.deleteAtIndex(1);  // now the linked list is 1->3
    	System.out.println(linkedList.get(-3));            // returns 3
	}
}
