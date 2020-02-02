package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 *
 */
public class UniqueBinarySearchTreesII {
	
	public List<TreeNode> generateTrees(int n) {
        int array[] = new int[n];
        for(int i = 1; i <= n; i++) {
        	array[i - 1] = i;
        }
        
        return generate(array, 0, n - 1);
    }
	
	private List<TreeNode> generate(int array[], int startIndex, int endIndex) {
		List<TreeNode> list = new ArrayList<>();
		
		if(startIndex > endIndex) 
			return list;
		
		if(startIndex == endIndex) {
			list.add(new TreeNode(array[startIndex]));
			return list;
		}
		
		for(int i = startIndex; i <= endIndex; i++) {
			List<TreeNode> left = generate(array, startIndex, i - 1);
			List<TreeNode> right = generate(array, i + 1, endIndex);
			if(left.size() == 0) {
				for(TreeNode r: right) {
					TreeNode root = new TreeNode(array[i]);
					root.left = null;
					root.right = r;
					list.add(root);
				}
			}
			
			if(right.size() == 0) {
				for(TreeNode l: left) {
					TreeNode root = new TreeNode(array[i]);
					root.left = l;
					root.right = null;
					list.add(root);
				}
			}
			
			else {
				for(TreeNode l : left) {
					for(TreeNode r: right) {
						TreeNode root = new TreeNode(array[i]);
						root.left = l;
						root.right = r;
						list.add(root);
					}
				}
			}
			
		}
		
		return list;
	}
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		UniqueBinarySearchTreesII sol = new UniqueBinarySearchTreesII();
		List<TreeNode> list = sol.generateTrees(3);
		
		for(TreeNode root : list ) {
			sol.print(root);
			System.out.println();
		}
	}
	
	private void print(TreeNode root) {
		if(root == null)
			return;
		System.out.print(root.val + ", ");
		print(root.left);
		print(root.right);
	}
}
