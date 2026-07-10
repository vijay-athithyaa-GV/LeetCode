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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        return TreeCon(0,n-1,preorder,0,n-1,inorder,map);
    }

    public TreeNode TreeCon(int prest,int prend,int[] preorder,int inst,int inend,int[] inorder,Map<Integer,Integer> index){
        //from here logic comes in...
        if(inst>inend || prest>prend) return null;

        if(inst < 0||inend >inorder.length-1) return null;

        TreeNode root = new TreeNode(preorder[prest]);

        int ind = index.get(preorder[prest]);//inorder based index..
        int lsize = ind - inst;//doubt in the prest indexing..(for inorder)
        int rsize = inend - ind;
        root.left = TreeCon(prest+1,prest+lsize,preorder,inst,ind-1,inorder,index);
        root.right = TreeCon(prest+lsize+1,prend,preorder,ind+1,inend,inorder,index);
        return root;
 
    }
}