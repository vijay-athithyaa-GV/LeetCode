/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxi = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int left = balance(root.left);
        int right = balance(root.right);
        maxi = Math.max(maxi,left+right);
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return maxi;
    }

    public int balance(TreeNode root){
        if(root==null) return 0;
        int l = balance(root.left);
        int r = balance(root.right);
        return Math.max(l,r)+1;
    }
}