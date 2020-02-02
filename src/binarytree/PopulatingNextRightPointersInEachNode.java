package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
		
		if(root == null) {
			return;
		}
        
		Queue<TreeLinkNode> q1 = new LinkedList<TreeLinkNode>();
		Queue<TreeLinkNode> q2 = new LinkedList<TreeLinkNode>();
		Queue<TreeLinkNode> current = q1;
		Queue<TreeLinkNode> other = q2;
		
		current.add(root);
		
		while(!current.isEmpty() || !other.isEmpty()) {
			TreeLinkNode prev = null;
			while(!current.isEmpty()) {
				TreeLinkNode node = current.remove();
				if(node.left != null) {
					other.add(node.left);
				}
				if(node.right != null) {
					other.add(node.right);
				}
				
				if(prev != null) {
					prev.next = node;
				}
				
				prev = node;
			}
			
			Queue<TreeLinkNode> temp = current; 
			current = other;
			other = temp;
		}
    }
}
