package test;

/**
 *Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them. 
 *
 */
public class DiameterOfBinaryTree {
	
	public int diameterOfBinaryTree(TreeNode root) {
		int[] result = diameter(root);
		return result[0];
    }
	
	private int[] diameter(TreeNode root) {
		
		int[] result = {0, 0};
		if(root == null) {
			return result;
		}
		
		int[] left = diameter(root.left);
		int[] right = diameter(root.right);
		
		int d = 0;
		if(root.left != null) {
			d += left[1];
		}
		
		if(root.right != null) {
			d += right[1];
		}
		
		result[0] = max(d, left[0], right[0]);
		result[1] = 1 + max(left[1], right[1]);
		
		return result;
	}
	
	private int max(int... args) {
		int max = 0;
		for(int arg : args) {
			if(arg > max) {
				max = arg;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		
	}
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
