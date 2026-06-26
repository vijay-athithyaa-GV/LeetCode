import java.util.*;

class Solution {
    int cnt = 0;
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int vis[][] = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(vis[i],0);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1' && vis[i][j]!=1){
                    dfs(i,j,vis,grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public void dfs(int row,int col,int vis[][],char grid[][]){
        vis[row][col] = 1;
        int dr[] = {-1,0,1,0};
        int dc[] = {0,1,0,-1};
        for(int i=0;i<4;i++){
            int newr = row+dr[i];
            int newc = col+dc[i];

            if(newr>=0 && newr<grid.length && newc>=0 && newc<grid[0].length){
                if(grid[newr][newc]=='1' && vis[newr][newc]!=1){
                    dfs(newr,newc,vis,grid);
                }
            }
        }
    }
}