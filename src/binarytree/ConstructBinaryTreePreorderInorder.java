package binarytree;

public class ConstructBinaryTreePreorderInorder {
	
	private int pIndex = 0;
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		pIndex = 0;
        return buildTree(inorder, preorder, 0, inorder.length - 1);
    }
	
	private TreeNode buildTree(int[] inorder, int[] preorder, int start, int end) {
		if(start > end) {
			return null;
		}
		
		int value = preorder[pIndex++];
		TreeNode node = new TreeNode(value);
		
		int iIndex = -1;
		for(int i = start; i <= end; i++) {
			if(inorder[i] == value) {
				iIndex = i;
				break;
			}
		}
		
		node.left = buildTree(inorder, preorder, start, iIndex - 1);
		node.right = buildTree(inorder, preorder, iIndex + 1,  end);
		return node;
	}
}
