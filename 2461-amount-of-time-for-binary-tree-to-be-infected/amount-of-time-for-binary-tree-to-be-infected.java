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
    Map<TreeNode,Boolean> vis = new HashMap<>();
    Map<TreeNode,TreeNode> parent = new HashMap<>();
    int time = 0;
    public int amountOfTime(TreeNode root, int start) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return 0;
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.remove();
            if(node.left != null){
                q.add(node.left);
                parent.put(node.left,node);
            }
            if(node.right != null){
                q.add(node.right);
                parent.put(node.right,node);
            }
        }
        //logic for visiting of the node...
        visiting(root,start);
        return time;
    }
    
    public void visiting(TreeNode root,int start){
        TreeNode startNode = null;
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return;
        q.add(root);
        // to find the start node..
        while(!q.isEmpty()){
            TreeNode node = q.remove();
            if(node.val == start){
                startNode = node;
                break;
            }
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
        }

        if(startNode == null){
            time = 0;
            return;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.add(startNode);
        vis.put(startNode,true);
        while(!q1.isEmpty()){
            boolean flag = false;
            int size = q1.size();
            while(size-->0){
                TreeNode node = q1.remove();
                if(node.left != null && !vis.containsKey(node.left)){
                    q1.add(node.left); 
                    vis.put(node.left,true);
                    flag = true;
                }
                if(node.right != null && !vis.containsKey(node.right)){
                    q1.add(node.right); 
                    vis.put(node.right,true);
                    flag = true;
                }
                TreeNode par = parent.get(node);
                if(par!=null && !vis.containsKey(par)){
                    q1.add(par); 
                    vis.put(par,true);
                    flag = true;
                }
            }
            if(flag) time++;  
        }
    }
}