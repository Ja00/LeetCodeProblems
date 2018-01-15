/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Just think about what is the condition for trimming, and when to stop the recursion.


class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null) {
            return null;
        }

        if(root.val < L ) {
            //this root and its left sub-tree need to be trimmed.
            return trimBST(root.right, L, R);
        } else if (root.val > R) {
            //same logic
            return trimBST(root.left, L, R);
        } else {
            //this root is in the range [L, R], let it be the root.
            //recursively trim the tree.
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
        }
        return root;
    }
}
