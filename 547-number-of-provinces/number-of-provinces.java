import java.util.*;

class Solution {
    int con = 0;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int vis[] = new int[n];
        Arrays.fill(vis,0);
        for(int i=0;i<n;i++){
            if(vis[i]!=1){
                dfs(i,vis,isConnected);
                con++;
            }
        }
        return con;
    }
    public void dfs(int node,int vis[],int[][] grid){
        vis[node] = 1;
        int n = grid.length;
         for(int i=0;i<n;i++){
            if(grid[node][i] == 1 && vis[i]!=1){
                dfs(i,vis,grid);
            }
        }
    }
}