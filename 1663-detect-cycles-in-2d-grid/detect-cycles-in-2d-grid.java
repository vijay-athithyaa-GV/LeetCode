import java.util.*;

class Solution {
    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(vis[i],0);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]!=1){
                    if(dfs(i,j,-1,-1,grid,vis,grid[i][j])) return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int row,int col,int prow,int pcol,char grid[][],int vis[][],char ch){
        int n = grid.length;
        int m = grid[0].length;
        vis[row][col] = 1;
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow = row+drow[i];
            int ncol = col+dcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                if(grid[nrow][ncol]!=ch) continue;
                if(vis[nrow][ncol] == 0){
                    if(dfs(nrow,ncol,row,col,grid,vis,grid[nrow][ncol])) return true;
                }
                else if(nrow!=prow || ncol!=pcol) return true;
            } 
        }
        return false;
    }
}