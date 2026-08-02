import java.util.*;

class pair{
    int i,j,tim;
    pair(int i,int j,int tim){
        this.i = i;
        this.j = j;
        this.tim = tim;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        //0 -> empty
        //1 -> fresh
        //2 -> rotten
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(vis[i],0);
        int cnt = 0;
        Queue<pair> q = new LinkedList<>();
        int flg = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new pair(i,j,0));
                    vis[i][j] = 1;
                }
            }
        }
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        int tm = 0;
        while(!q.isEmpty()){
          //  int size = q.size();
            pair curr = q.poll();
            int i = curr.i;
            int j = curr.j;
            int t = curr.tim;
            tm = Math.max(t,tm);
           
                for(int k=0;k<4;k++){
                    int row = i+drow[k];
                    int col = j+dcol[k];
                    if(row>=0 && row<n && col>=0 && col<m && vis[row][col]!=1 && grid[row][col]==1){
                        grid[row][col] = 2;
                        q.add(new pair(row,col,t+1));
                        vis[row][col]=1;
                    }
                }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]!=1){
                    return -1;
                }
            }
        }
        return tm;
    }
}