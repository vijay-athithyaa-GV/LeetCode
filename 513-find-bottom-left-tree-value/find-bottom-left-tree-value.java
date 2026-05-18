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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();   
        if(root==null) return 0;
        que.add(root);
        int curr = -1;

        while(!que.isEmpty()){
            TreeNode node = que.poll();
            curr = node.val;
            if(node.right!=null) que.add(node.right);
            if(node.left!=null) que.add(node.left);
        }

        return curr;
    }
}