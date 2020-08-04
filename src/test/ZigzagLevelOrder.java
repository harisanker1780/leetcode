package test;

import java.util.ArrayList;
import java.util.List;

public class ZigzagLevelOrder {
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null) {
			return result;
		}
		
		List<TreeNode> nextLevel = new ArrayList<TreeNode>();
		nextLevel.add(root);
		List<Integer> r = new ArrayList<Integer>();
		r.add(root.val);
		result.add(r);
		int order = 0;
		while(true) {
			List<TreeNode> copy = nextLevel;
			nextLevel = new ArrayList<TreeNode>();
			
			if(order == 0) {
				for(int i = copy.size() - 1; i >= 0; i--) {
					TreeNode node = copy.get(i);
					if(node.right != null) {
						nextLevel.add(node.right);
					}
					if(node.left != null) {
						nextLevel.add(node.left);
					}
				}
			} else {
				for(int i = copy.size() - 1; i >= 0; i--) {
					TreeNode node = copy.get(i);
					if(node.left != null) {
						nextLevel.add(node.left);
					}
					if(node.right != null) {
						nextLevel.add(node.right);
					}
				}
			}
			
			if(nextLevel.size() > 0) {
				r = new ArrayList<Integer>();
				for(TreeNode n : nextLevel) {
					r.add(n.val);
				}
				
				result.add(r);
			} else {
				break;
			}
			
			order = (order == 0) ? 1 : 0;
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
