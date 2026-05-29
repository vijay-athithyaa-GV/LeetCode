import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int island=0;
        int vis[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1' && vis[i][j]!=1){
                    island++;
                    bfs(grid,n,m,i,j,vis);
                }
            }
        }
        return island; 
    }
    public void bfs(char[][] grid,int n,int m,int i,int j,int vis[][]){
        Queue<int[]> q = new LinkedList<>();
        vis[i][j] = 1;
        q.add(new int[]{i,j});
        while(!q.isEmpty()){
            int[] pos = q.remove();
            int x = pos[0];
            int y = pos[1];
            if((x+1)<n && grid[x+1][y] == '1' && vis[x+1][y]!=1){
                q.add(new int[]{x+1,y});
                vis[x+1][y]=1;
            }
            if((y+1)<m && grid[x][y+1] == '1' && vis[x][y+1]!=1){
                q.add(new int[]{x,y+1});
                vis[x][y+1] = 1;
            }
            if((x-1)>=0 && grid[x-1][y] == '1' && vis[x-1][y]!=1){
                q.add(new int[]{x-1,y});
                vis[x-1][y] = 1;
            }
            if((y-1)>=0 && grid[x][y-1] == '1' && vis[x][y-1]!=1){
                q.add(new int[]{x,y-1});
                vis[x][y-1] = 1;
            } 
        }
    }
}