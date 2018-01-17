//Start from every node in tree S, find if there's equalities recursively.
//If all nodes match, return true.
//If there's an unmatch, try next node from S, s.left, s.right.


class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
    	if(s == null) {
    		return false;
    	}

    	return equals(s, t) || equals(s.left, t) || equals(s.right, t);
    }

    public boolean equals(TreeNode s, TreeNode t) {
    	if(s == null && t == null) {
    		return true;
    	} else if (s == null || t == null) {
    		return false;
    	} else {
    		return (s.val == t.val) && equals(s.left, t.left) && equals(s.right, t.right);
    	}
    }
}