import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {
        //1 -> land, 0-> water..
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        int vis[][] = new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(vis[i],0);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]!=1 && grid[i][j]=='1'){
                    dfs(grid,vis,i,j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public void dfs(char grid[][],int vis[][],int i,int j){
        vis[i][j] = 1;
        int n = grid.length;
        int m = grid[0].length;

        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        for(int k=0;k<4;k++){
            int row = drow[k]+i;
            int col = dcol[k]+j;
            if(row>=0 && row<n && col>=0 && col<m){
                if(vis[row][col]!=1 && grid[row][col]=='1'){
                    dfs(grid,vis,row,col);
                }
            }
        }
    }
}