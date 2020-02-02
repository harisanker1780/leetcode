package binarytree;

import java.util.Stack;

public class LowestCommonAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		Stack<TreeNode> path1 = new Stack<TreeNode>();
		Stack<TreeNode> path2 = new Stack<TreeNode>();
		
		path(root, p, path1);
		path(root, q, path2);
		
		TreeNode lca = null;
		while(!path1.isEmpty() && !path2.isEmpty()) {
			TreeNode node1 = path1.pop();
			TreeNode node2 = path2.pop();
			if(node1 == node2) {
				lca = node1;
			}
		}
		
        return lca;
    }
	
	private void path(TreeNode root, TreeNode node, Stack<TreeNode> stack) {
		if(root == null) {
			return;
		}
		
		if(root == node) {
			stack.push(root);
			return;
		}
		
		if(!stack.isEmpty()) {
			return;
		}
		
		path(root.left, node, stack);
		path(root.right, node, stack);
		if(!stack.isEmpty()) {
			stack.push(root);
		}
	}
	
	public static void main(String[] args) {
		LowestCommonAncestor solution = new LowestCommonAncestor();
		
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		
		TreeNode lca = solution.lowestCommonAncestor(root, root.left, root.left.right.right);
		System.out.println(lca.val);
		
		/*Stack<TreeNode> stack = new Stack<TreeNode>();
		solution.path(root, root.left, stack);
		
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			System.out.println(node.val);
		}*/
	}
}
