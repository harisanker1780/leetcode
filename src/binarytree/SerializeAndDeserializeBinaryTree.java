package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
	
	
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	if(root == null) {
    		return null;
    	}
    	
    	StringBuilder builder = new StringBuilder();
    	levelOrder(root, builder);
    	String result = builder.toString() ;
    	return result.substring(0, result.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null) {
        	return null;
        }
        
        String[] array = data.split(",");
        return buildTree(array, 0, array.length);
    }
    
    private TreeNode buildTree(String[] array, int index, int size) {
    	if(index >= size) {
    		return null;
    	}
    	
    	String val = array[index];
    	TreeNode node = new TreeNode(Integer.parseInt(val));
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(node);
    	
    	while(!queue.isEmpty() && index < size) {
    		TreeNode n = queue.remove();
    		val = array[++index];
    		if(val.equals("NULL")) {
    			n.left = null;
    		}
    		else {
    			TreeNode left = new TreeNode(Integer.parseInt(val));
    			n.left = left;
    			queue.add(left);
    		}
    		
    		val = array[++index];
    		if(val.equals("NULL")) {
    			n.right = null;
    		}
    		else {
    			TreeNode right = new TreeNode(Integer.parseInt(val));
    			n.right = right;
    			queue.add(right);
    		}
    	}
    	
    	return node;
    }
    
    private void levelOrder(TreeNode root, StringBuilder builder) {
		
		builder.append(root.val);
		builder.append(",");
		
		Queue<TreeNode> current = new LinkedList<TreeNode>();
		Queue<TreeNode> other = new LinkedList<TreeNode>();
		
		current.add(root);
		
		while(!current.isEmpty() || !other.isEmpty()) {
			while(!current.isEmpty()) {
				TreeNode node = current.remove();
				if(node.left != null) {
					other.add(node.left);
					builder.append(node.left.val + ",");
				}
				else {
					builder.append("NULL,");
				}
				if(node.right != null) {
					other.add(node.right);
					builder.append(node.right.val + ",");
				}
				else {
					builder.append("NULL,");
				}
			}
			
			Queue<TreeNode> temp = current; 
			current = other;
			other = temp;
		}
	}
    
    public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		
		SerializeAndDeserializeBinaryTree solution = new SerializeAndDeserializeBinaryTree();
		String sol = solution.serialize(root);
		System.out.println(sol);
		TreeNode node1 = solution.deserialize(sol);
		String result1 = solution.serialize(node1);
		System.out.println(result1);
	}
}
