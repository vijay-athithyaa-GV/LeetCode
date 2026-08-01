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
class pair{
    int pos;
    TreeNode node;
    pair(int pos,TreeNode node){
        this.pos = pos;
        this.node = node;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        int maxwd = 0;
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(0,root));

        while(!q.isEmpty()){
            int size = q.size();
            int min = q.peek().pos;
            int left = 0;
            int right = 0;
            for(int i=0;i<size;i++){
                TreeNode node = q.peek().node;
                int curr = q.peek().pos - min;
                q.poll();
                if(i == 0)left = curr;
                if(i == size-1) right = curr;
                
                if(node.left!=null) q.add(new pair(curr*2+1,node.left));
                if(node.right!=null) q.add(new pair(curr*2+2,node.right));
            }
            maxwd = Math.max(maxwd,right-left+1);
        }
        return maxwd;
    }
}