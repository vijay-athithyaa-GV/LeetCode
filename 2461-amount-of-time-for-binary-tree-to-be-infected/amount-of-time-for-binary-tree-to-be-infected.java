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
    Set<TreeNode> vis = new HashSet<>();
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
        vis.add(startNode);
        while(!q1.isEmpty()){
            boolean flag = false;
            int size = q1.size();
            while(size-->0){
                TreeNode node = q1.remove();
                if(node.left != null && !vis.contains(node.left)){
                    q1.add(node.left); 
                    vis.add(node.left);
                    flag = true;
                }
                if(node.right != null && !vis.contains(node.right)){
                    q1.add(node.right); 
                    vis.add(node.right);
                    flag = true;
                }
                TreeNode par = parent.get(node);
                if(par!=null && !vis.contains(par)){
                    q1.add(par); 
                    vis.add(par);
                    flag = true;
                }
            }
            if(flag) time++;  
        }
    }
}