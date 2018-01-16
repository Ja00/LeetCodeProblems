//Can't stuck in finding the relation diameter of current tree and its subtrees,
//as there are 2 situations: pass cur-root, or not.


//Since the longest path might not pass the cur-root,
//a subtree should return the longest path to a leave + 1 to its parent, 
//and use a global variable to store the longest path = left + right.
class Solution {
	
	int max = 0;
	
	public int diameterOfBinaryTree(TreeNode root) {
		dfs(root);
		return max;
	}

	public int dfs(TreeNode root) {
		if(root == null) {
			return 0;
		}

		int left = dfs(root.left);
		int right = dfs(root.right);

		max = Math.max(max, left + right);
		return Math.max(left, right) + 1;
	}
}