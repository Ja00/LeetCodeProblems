//Recursively call the merge method, traversing 2 trees.
//In every traversal, 2 trees moved to the same position.

class Solution {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if(t1 == null) {
			return t2;
		} else if(t2 == null) {
			return t1;
		} else {
			TreeNode newNode = new TreeNode(t1.val + t2.val);
			newNode.left = mregeTrees(t1.left, t2.left);
			newNode.right = mergeTrees(t1.right, t2.right);
			return newNode;
		}

	}
}