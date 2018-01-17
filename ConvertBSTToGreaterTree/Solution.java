//The key is to pass the "post-order" traversal info to the current node.

class Solution {
	//Since node has no info about its parent node (or should say node already traversed), we need
	//a global variable to record the current total sum.

	int cur = 0;

	public TreeNode convertBST(TreeNode root) {
		if(root == null) {
			return root;
		}

		convertBST(root.right);//need to process the right subtree first, as we need greater nodes info
		//I assigned the return from right sub-tree to the root.right before, but it's unnecessary.
		//root.right = convertBST(root.right);
		root.val += cur;
		cur = root.val;
		convertBST(root.left);

		return root;
	}
}
