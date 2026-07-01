import java.util.*;

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = Integer.MIN_VALUE;
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        for(int i=0;i<n;i++)    Arrays.fill(vis[i],0);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int sub[] = new int[1];
                sub[0] = 0;
                if(grid[i][j] == 1 && vis[i][j]!=1){
                    dfs(i,j,grid,vis,sub);
                }
                max = Math.max(max,sub[0]);
            }
        }
        return max;
    }

    public void dfs(int row,int col,int grid[][],int vis[][],int sub[]){
        int n = grid.length;
        int m = grid[0].length;
        vis[row][col] = 1;
        sub[0] = sub[0]+1;
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,-1,0,1};
        for(int i=0;i<4;i++){
            int nrow = row+drow[i];
            int ncol = col+dcol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                //core logic
                 if(grid[nrow][ncol] == 1 && vis[nrow][ncol]!=1){
                    dfs(nrow,ncol,grid,vis,sub);
                 }
            }            
        }
    }
}
