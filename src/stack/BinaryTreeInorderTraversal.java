package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	
	public List<Integer> inorderTraversal(TreeNode root) {
		
		List<Integer> inorder = new ArrayList<Integer>();
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(root != null) {
			stack.push(root);
			root = root.left;
		}
		
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			inorder.add(node.val);
			
			node = node.right;
			while(node != null) {
				stack.push(node);
				node = node.left;
			}
		}
		
        return inorder;
    }
	
	
	
	public static void main(String[] args) {
		BinaryTreeInorderTraversal solution = new BinaryTreeInorderTraversal();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		List<Integer> inorder = solution.inorderTraversal(root);
		System.out.println(Arrays.toString(inorder.toArray()));
	}
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) { val = x; }
}
