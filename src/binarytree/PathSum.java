package binarytree;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) {
			return false;
		}
		return hasPathSum(root, sum, 0);
	}
	 
	private boolean hasPathSum(TreeNode root, int target, int sum) {
		
		if(root == null) {
			return false;
		}
		
		if(isLeafNode(root) && sum + root.val == target) {
			return true;
		}
		
		return hasPathSum(root.left, target, sum + root.val) || hasPathSum(root.right, target, sum + root.val);
	}
	
	private boolean isLeafNode(TreeNode node) {
		return node.left == null && node.right == null;
	}
}
