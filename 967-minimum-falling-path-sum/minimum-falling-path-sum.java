import java.util.*;

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int min = Integer.MAX_VALUE;
        int dp[][] = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        for(int i=0;i<n;i++){
            min = Math.min(min,findPath(n-1,i,matrix,dp));
        }
        return min;
    }

    public int findPath(int i,int j,int[][]arr,int[][]dp)
    {   
        int n = arr.length;
        int m = arr[0].length;
        if( j<0 || j>=m) return Integer.MAX_VALUE;
        if(i == 0){
            return arr[i][j];
        }
        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];
      
        int same = findPath(i-1,j,arr,dp);
       
        int left = findPath(i-1,j-1,arr,dp);
        int right = findPath(i-1,j+1,arr,dp);
        int minVal = Math.min(same,Math.min(left,right));
        if(minVal == Integer.MAX_VALUE) return dp[i][j] = Integer.MAX_VALUE;
        return dp[i][j] =  minVal+arr[i][j]; 
    }
}