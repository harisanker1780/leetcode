package recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 *
 */
public class BinaryTreeLevelOrderTraversal {
	
	 public List<List<Integer>> levelOrder(TreeNode root) {
		 List<List<Integer>> result = new ArrayList<List<Integer>>();
		 
		 if(root != null) {
			 Queue<TreeNode> q1 = new LinkedList<>();
			 Queue<TreeNode> q2 = new LinkedList<>();
			 
			 q1.add(root);
			 
			 while(!q1.isEmpty() || !q2.isEmpty()) {
				 
				 if(!q1.isEmpty()) {
					 List<Integer> list = new ArrayList<>();
					 while(!q1.isEmpty()) {
						 TreeNode node= q1.remove();
						 list.add(node.val);
						 
						 if(node.left != null) {
							 q2.add(node.left);
						 }
						 
						 if(node.right != null) {
							 q2.add(node.right);
						 }
					 }
					 
					 result.add(list);
				 }
				 
				 if(!q2.isEmpty()) {
					 List<Integer> list = new ArrayList<>();
					 while(!q2.isEmpty()) {
						 TreeNode node= q2.remove();
						 list.add(node.val);
						 
						 if(node.left != null) {
							 q1.add(node.left);
						 }
						 
						 if(node.right != null) {
							 q1.add(node.right);
						 }
					 }
					 
					 result.add(list);
				 }
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
