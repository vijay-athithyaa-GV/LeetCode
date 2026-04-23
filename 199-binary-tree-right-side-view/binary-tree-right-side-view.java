import java.util.*;
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightside(root,res,0);
        return res;
    }

    public void rightside(TreeNode root,List<Integer> res,int level){
        if(root == null) return;
        if(res.size()==level) res.add(root.val);
        rightside(root.right,res,level+1);
        rightside(root.left,res,level+1);
    }
}