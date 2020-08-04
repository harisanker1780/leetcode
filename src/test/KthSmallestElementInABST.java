package test;

/**
 * 
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

 

Constraints:

The number of elements of the BST is between 1 to 10^4.
You may assume k is always valid, 1 <= k <= BST's total elements.
 *
 */
public class KthSmallestElementInABST {
	
	public int kthSmallest(TreeNode root, int k) {
        int result[] = {0, 0};
        kthSmallest(root, k, result);
        return result[1];
    }
	
	private int[] kthSmallest(TreeNode root, int k, int[] result) {
		
		if(root == null)
			return result;
		
		if(result[0] == k)
			return result;
		
		if(root.left == null && root.right == null) {
			result[0] = result[0] + 1;
			result[1] = root.val;
			return result;
		}
		
		if(root.left != null) {
			kthSmallest(root.left, k, result);
		}
		
		if(result[0] == k) {
			return result;
		}
		
		result[0] = result[0] + 1;
		result[1] = root.val;
		
		if(root.right != null) {
			kthSmallest(root.right, k, result);
		}
		
		return result;
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

}
