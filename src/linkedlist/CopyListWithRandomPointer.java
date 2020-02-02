package linkedlist;

public class CopyListWithRandomPointer {
	
	public Node copyRandomList(Node head) {
        return null;
    }
	
	class Node {
	    public int val;
	    public Node next;
	    public Node random;

	    public Node() {}

	    public Node(int _val,Node _next,Node _random) {
	        val = _val;
	        next = _next;
	        random = _random;
	    }
	};

}


