import java.util.*;

class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int vis[][] = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(vis[i],0);
        }
        for(int i=0;i<n;i++){
            if(board[i][0]=='O' && vis[i][0]!=1){
                dfs(i,0,board,vis);
            }
        }
        for(int i=0;i<m;i++){
            if(board[0][i]=='O' && vis[0][i]!=1){
                dfs(0,i,board,vis);
            }
        }
        for(int i=0;i<n;i++){
            if(board[i][m-1]=='O' && vis[i][m-1]!=1){
                dfs(i,m-1,board,vis);
            }
        }
        for(int i=0;i<m;i++){
            if(board[n-1][i]=='O' && vis[n-1][i]!=1){
                dfs(n-1,i,board,vis);
            }
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         System.out.print(vis[i][j]+" ");
        //     }
        //     System.out.println(); 
        // }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(int row,int col,char board[][],int vis[][]){
        int n = board.length;
        int m = board[0].length;
        vis[row][col] = 1;
        // board[row][col] = 'X';
        int dr[] = {-1,0,1,0};
        int dc[] = {0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow = dr[i]+row;
            int ncol = dc[i]+col;
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                 if(board[nrow][ncol]=='O' && vis[nrow][ncol]==0){
                    dfs(nrow,ncol,board,vis);
                 }
            }
        }
    }
}