import java.util.*;

class pair{
    int row;
    int col;
    int val;
    pair(int row,int col,int val){
        this.row = row;
        this.col = col;
        this.val = val;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(vis[i],0);
        }
        int time = 0;
        Queue<pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    pair p = new pair(i,j,time);
                    vis[i][j] = 1;
                    q.add(p);
                }
            }
        }
        while(!q.isEmpty()){
            pair ele = q.poll();
            int row = ele.row;
            int col = ele.col;
            int val = ele.val;
            time = Math.max(time,val);
            if(row+1<n && vis[row+1][col] != 1 && grid[row+1][col] == 1){
                pair p = new pair(row+1,col,val+1);
                vis[row+1][col] = 1;
                q.add(p);
            }
            if(col+1<m && vis[row][col+1]!=1 && grid[row][col+1] == 1){
                pair p = new pair(row,col+1,val+1);
                vis[row][col+1] = 1;
                q.add(p);
            }
            if(row-1>=0 && vis[row-1][col]!=1 && grid[row-1][col] == 1){
                pair p = new pair(row-1,col,val+1);
                vis[row-1][col] = 1;
                q.add(p);
            }
            if(col-1>=0 &&  vis[row][col-1]!=1 && grid[row][col-1] == 1){
                pair p = new pair(row,col-1,val+1);
                vis[row][col-1] = 1;
                q.add(p);
            }
        }
        for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(grid[i][j] == 1 && vis[i][j] == 0) return -1;
            }
        }
        return time;
    }
}