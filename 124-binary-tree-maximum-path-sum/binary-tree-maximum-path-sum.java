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
    int maxi = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        maxpathsum(root);
        return maxi;
    }

    public int maxpathsum(TreeNode root){
        if(root == null) return 0;
        int left = maxpathsum(root.left);
        int right = maxpathsum(root.right);
        maxi = Math.max(maxi,left+right+root.val);
        int res = Math.max(left,right)+root.val;
        return res<=0?0:res;
    }
    // public int pathsum(TreeNode root){
    //     int l = 0;
    //     int r = 0;
    //     if(root == null) return 0;
    //     if(root.left !=null){l = pathsum(root.left);}
    //     if(root.right != null){r = pathsum(root.right);}
    //     return Math.max(l,r)+root.val;
    // }
}