package test;

/**
 * Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
 *
 */
public class BinaryTreeMaximumPathSum {

	public int maxPathSum(TreeNode root) {
        return maxPathSumUtil(root).pathSum;
    }
	
	private Result maxPathSumUtil(TreeNode root) {
		if(root == null)
			return new Result(0, Integer.MIN_VALUE);
		
		Result left = maxPathSumUtil(root.left);
		Result right = maxPathSumUtil(root.right);
		int maxValue = root.val + Math.max(0, Math.max(left.maxValue, right.maxValue));
		maxValue = Math.max(0, maxValue);
		int pathSum = root.val + left.maxValue + right.maxValue;
		return new Result(maxValue, Math.max(pathSum, Math.max(left.pathSum, right.pathSum)));
	}
	
	class Result {
		int maxValue, pathSum;
		public Result(int maxValue, int pathSum) {
			this.maxValue = maxValue;
			this.pathSum = pathSum;
		}
	}
	
	class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		BinaryTreeMaximumPathSum sol = new BinaryTreeMaximumPathSum();
		System.out.println(sol);
	}
}


