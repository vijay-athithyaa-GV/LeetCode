import java.util.*;

class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int vis[][] = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(vis[i],0);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] == 0){
                    vis[i][j]=1;
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] == 1){
                    for(int k1=0;k1<n;k1++){
                        matrix[k1][j] = 0;
                    }
                    for(int k1=0;k1<m;k1++){
                        matrix[i][k1] = 0;
                    }
                }
            }
        }
    }
}