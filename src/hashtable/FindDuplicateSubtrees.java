package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {
	
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		
		List<TreeNode> list = new ArrayList<TreeNode>();
		if(root == null)
			return list;
		
		Map<String, TreeNode> map = new HashMap<String, TreeNode>();
		Map<String, TreeNode> result = new HashMap<String, TreeNode>();
		serialize(root, map, result);
		
		
		Iterator<String> itr = result.keySet().iterator();
		while(itr.hasNext()) {
			list.add(result.get(itr.next()));
		}
		return list;
    }
	
	private String serialize(TreeNode node, Map<String, TreeNode> map, Map<String, TreeNode> result) {
		
		if(node == null)
			return "";
		
		StringBuilder s = new StringBuilder();
		if(node.left != null){
			s.append("(");
			s.append(serialize(node.left, map, result));
			s.append(")");
		}
		
		if(node.right != null) {
			s.append(",");
			s.append("(");
			s.append(serialize(node.right, map, result));
			s.append(")");
		}
		
		String val = node.val + s.toString();
		if(map.containsKey(val)) {
			result.put(val, node);
		}
		else {
			map.put(val, node);
		}
		
		return String.valueOf(node.val + s.toString());
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(2);
		root.right.left.left = new TreeNode(4);
		root.right.right = new TreeNode(4);
		
		FindDuplicateSubtrees sol = new FindDuplicateSubtrees();
		List<TreeNode> list = sol.findDuplicateSubtrees(root);
		
		TreeNode array[] = new TreeNode[list.size()];
		System.out.println(Arrays.toString(list.toArray(array)));
	}
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
      
      public String toString() {
    	  return String.valueOf(val);
      }
}
