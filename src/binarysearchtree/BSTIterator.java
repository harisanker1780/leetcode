package binarysearchtree;

import java.util.Stack;

public class BSTIterator {
	
	private Stack<TreeNode> stack;
	
	public BSTIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		insert(root);
	}
	    
    public int next() {
        TreeNode top =  stack.pop();
        insert(top.right);
        return top.val;
    }
	    
	public boolean hasNext() {
	    return !stack.isEmpty();    
	}
	
	private void insert(TreeNode node) {
		while(node != null) {
			stack.push(node);
			node = node.left;
		}
	}
	
	class TreeNode {
	   int val;
	   TreeNode left;
	   TreeNode right;
	   TreeNode(int x) { val = x; }
    }

}
