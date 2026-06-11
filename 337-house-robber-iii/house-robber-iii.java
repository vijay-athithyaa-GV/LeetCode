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
import java.util.*;

class Solution {
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int opt[] = robHouse(root);
        return Math.max(opt[0],opt[1]);
    }

    public int[] robHouse(TreeNode root){
        if(root == null) return new int[2];

        int left[] = robHouse(root.left);
        int right[] = robHouse(root.right);
        int option[] = new int[2];
        //0 =  Take, 1 = nottake...
        option[0] = root.val+left[1]+right[1];
        option[1] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return option;
    }
}