package binarysearchtree;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

 

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
 */
public class BalancedBinaryTree {
	
	Map<TreeNode, Integer> map;
	
	public boolean isBalanced(TreeNode root) {
		
		if(root == null)
			return true;
		
		map = new HashMap<>();
		
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
		if(Math.abs(leftHeight - rightHeight) > 1)
			return false;
		
		return isBalanced(root.left) && isBalanced(root.right); 
				
    }
	
	
	private int height(TreeNode root) {
		if(root == null)
			return 0;
		
		if(map.containsKey(root)) {
			return map.get(root);
		}
		
		int height = 1 + Math.max(height(root.left), height(root.right));
		map.put(root, height);
		return height;
	}
	
	class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
