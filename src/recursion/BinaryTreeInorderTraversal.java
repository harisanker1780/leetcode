package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	
	 public List<Integer> inorderTraversal(TreeNode root) {
		 List<Integer> result = new ArrayList<Integer>();
		 Stack<TreeNode> stack = new Stack<TreeNode>(); 
		 
		 while(root != null) {
			 stack.push(root);
			 root = root.left;
		 }
		 
		 while(!stack.isEmpty()) {
			 TreeNode node = stack.pop();
			 result.add(node.val);
			 
			 node = node.right;
			 while(node != null) {
				 stack.push(node);
				 node = node.left;
			 }
		 }
		 
		 return result;
	 }
	
	 public class TreeNode {
	     int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	 }
}
