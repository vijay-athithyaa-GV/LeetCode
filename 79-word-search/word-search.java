import java.util.*;

class Solution {
    public boolean exist(char[][] board, String word) {
        int[] flag = new int[1];
        flag[0] = 0;
        int n = board.length;
        int m = board[0].length;
        int ind = 0;
        int vis[][] = new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(vis[i],0);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == word.charAt(ind) && vis[i][j]!=1){
                    vis[i][j] = 1;
                    solut(board,word,vis,i,j,ind,flag);
                    vis[i][j] = 0;
                }
            }
        }
        return flag[0]==1?true:false;
    }
    public void solut(char[][] board,String word,int vis[][],int i,int j,int ind,int flag[]){
        int n = board.length;
        int m = board[0].length;
        int wlen = word.length();
        if(ind == wlen-1){
            flag[0] = 1;
            return;
        }
        //if(i >= word.length()) return;
        if(word.charAt(ind) == board[i][j]){
            if(i+1<n && ind+1<wlen && vis[i+1][j]!=1){
                if(word.charAt(ind+1) == board[i+1][j]){
                    vis[i+1][j]=1;
                    solut(board,word,vis,i+1,j,ind+1,flag);
                    vis[i+1][j]=0;
                }
            
            }

            if(j+1<m && ind+1<wlen && vis[i][j+1]!=1){
                if(word.charAt(ind+1) == board[i][j+1]){
                    vis[i][j+1]=1;
                    solut(board,word,vis,i,j+1,ind+1,flag);
                    vis[i][j+1]=0;
                }
            }

            if(i-1>=0 && ind+1<wlen && vis[i-1][j]!=1){
                if(word.charAt(ind+1) == board[i-1][j]){
                    vis[i-1][j]=1;
                    solut(board,word,vis,i-1,j,ind+1,flag);
                    vis[i-1][j]=0;
                }
            }
            if(j-1>=0 && ind+1<wlen && vis[i][j-1]!=1){
                if(word.charAt(ind+1) == board[i][j-1]){
                    vis[i][j-1]=1;
                    solut(board,word,vis,i,j-1,ind+1,flag);
                    vis[i][j-1]=0;
                }
            }
        }
        else{
            return;
        }
            

            

            

    }
}