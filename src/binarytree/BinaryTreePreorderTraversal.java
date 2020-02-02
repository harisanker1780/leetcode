package binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
        preorderTraversal(root, list);
        return list;
    }
	
	private void preorderTraversal(TreeNode root, List<Integer> list) {
		if(root == null) {
			return;
		}
		
		list.add(root.val);
		preorderTraversal(root.left, list);
		preorderTraversal(root.right, list);
	}
}
