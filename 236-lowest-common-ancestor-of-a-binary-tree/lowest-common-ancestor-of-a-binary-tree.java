/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        return low(root,p,q);
    }
    public TreeNode low(TreeNode root,TreeNode p,TreeNode q){
        if(root == null) return root;
        if(root == p || root == q) return root;
        TreeNode left = low(root.left,p,q);
        TreeNode right = low(root.right,p,q);
        if(left!=null && right!=null) return root;
        if(left!=null) return left;
        return right;
    }
}