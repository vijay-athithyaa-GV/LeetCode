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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        StoreElement(res,root);
        int arr[] = res.stream().mapToInt(Integer::intValue).toArray();
        int i=0;
        int j=arr.length-1;
        while(i<j){
            if(arr[i]+arr[j] == k)
                return true;
            else if(arr[i]+arr[j]<k)
                i++;
            else 
                j--;
        }
        return false;
    }
    public void StoreElement(List<Integer> res, TreeNode root){
        if(root == null)
            return;        
        StoreElement(res,root.left);
        res.add(root.val);
        StoreElement(res,root.right);
    }

}