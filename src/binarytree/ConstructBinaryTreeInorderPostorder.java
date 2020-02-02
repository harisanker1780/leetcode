package binarytree;

public class ConstructBinaryTreeInorderPostorder {
	
	private int pIndex = 0;
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        pIndex = postorder.length - 1;
        return buildTree(inorder, postorder, 0, inorder.length - 1);
    }
	
	private TreeNode buildTree(int[] inorder, int[] postorder, int start, int end) {
		if(start > end) {
			return null;
		}
		
		int value = postorder[pIndex--];
		TreeNode node = new TreeNode(value);
		
		int iIndex = -1;
		for(int i = start; i <= end; i++) {
			if(inorder[i] == value) {
				iIndex = i;
				break;
			}
		}
		
		node.right = buildTree(inorder, postorder, iIndex + 1,  end);
		node.left = buildTree(inorder, postorder, start, iIndex - 1);
		return node;
	}
	
	public static void main(String[] args) {
		ConstructBinaryTreeInorderPostorder solution = new ConstructBinaryTreeInorderPostorder();
		int[] inorder = {9,3,15,20,7};
	    int[] postorder = {9,15,7,20,3};
	    
	    TreeNode node = solution.buildTree(inorder, postorder);
	    System.out.println(node.val);
	}
}
