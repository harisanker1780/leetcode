package binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> traversal = new ArrayList<List<Integer>>();
		levelOrder(root, traversal, 0);
		return traversal;
    }
	
	private void levelOrder(TreeNode root, List<List<Integer>> traversal, int level) {
		
		if(root == null) {
			return;
		}
		
		List<Integer> levelValues;
		if(traversal.size() > level) {
			levelValues = traversal.get(level);
		}
		else {
			levelValues = new ArrayList<Integer>();
			traversal.add(levelValues);
		}
		
		levelValues.add(root.val);
		levelOrder(root.left, traversal, level + 1);
		levelOrder(root.right, traversal, level + 1);
	}
}

