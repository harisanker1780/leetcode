package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
	
	public List<Integer> postorderTraversal(TreeNode root) {
        
		List<Integer> list = new ArrayList<Integer>();
		
		if(root == null) {
			return list;
		}
		
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<Integer> stack2 = new Stack<Integer>();
		
		stack1.push(root);
		while(!stack1.isEmpty()) {
			TreeNode elem = stack1.pop();
			if(elem.left != null) {
				stack1.push(elem.left);
			}
			if(elem.right != null) {
				stack1.push(elem.right);
			}
			stack2.push(elem.val);
		}
		
		while(!stack2.isEmpty()) {
			list.add(stack2.pop());
		}
		
		return list;
    }
	
	
}
