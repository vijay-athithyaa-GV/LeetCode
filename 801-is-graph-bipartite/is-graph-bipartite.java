import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int vis[] = new int[n];
        Arrays.fill(vis,-1);
        
        for(int i=0;i<n;i++){
            if(vis[i] == -1){
                vis[i] = 0;
                if(!dfs(i,vis,graph)) return false;
            }
        }
        return true;
    }

    public boolean dfs(int node,int[] vis,int graph[][]){
        int m = graph[node].length;
        for(int i=0;i<m;i++){
            int v = graph[node][i];
            if(vis[v]==-1){
                vis[v] = 1-vis[node];
                if(!dfs(v,vis,graph)) return false;
            }
            else if(vis[v] == vis[node]) return false;
        }
        return true;
    }
}