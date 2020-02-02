package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SymmetricTree {
	
	public boolean isSymmetric(TreeNode root) {
        
		if(root == null) {
			return true;
		}
		
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();
		Queue<TreeNode> current = q1;
		Queue<TreeNode> other = q2;
		
		current.add(root);
		
		while(!current.isEmpty() || !other.isEmpty()) {
			List<Integer> levelValues = new ArrayList<Integer>();
			while(!current.isEmpty()) {
				TreeNode node = current.remove();
				if(node.left != null) {
					other.add(node.left);
					levelValues.add(node.left.val);
				}
				else {
					levelValues.add(null);
				}
				if(node.right != null) {
					other.add(node.right);
					levelValues.add(node.right.val);
				}
				else {
					levelValues.add(null);
				}
			}
			
			if(levelValues.size() % 2 != 0) {
				return false;
			}
			
			int i = 0;
			int size = levelValues.size();
			while(i  < (size / 2)) {
				Integer first = levelValues.get(i);
				Integer last = levelValues.get(size - (i + 1));
				
				if((first == null && last != null) || (last == null && first != null)) {
					return false;
				}
				else if(first != null && last != null) {
					if(first != last) {
						return false;
					}
				}
				
				i++;
			}
			
			Queue<TreeNode> temp = current; 
			current = other;
			other = temp;
		}
		
		return true;
    }
	
	public static void main(String[] args) {
		SymmetricTree solution = new SymmetricTree();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		//root.left.left = new TreeNode(3);
		root.left.left = new TreeNode(3);
		//root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(3);
		
		System.out.println(solution.isSymmetric(root));
	}
}
