import java.util.*;

class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int res[][] = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(res[i],-1);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] ==0)
                    res[i][j] = 1;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(res[i][j] == 1)
                {
                    for(int k=0;k<m;k++)
                        matrix[i][k] = 0;
                    for(int k=0;k<n;k++)
                        matrix[k][j] = 0;
                }
            }
        }
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}