class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];
        for(int j=0;j<m;j++){
            dp[0][j] = matrix[0][j];
        }
        int top = 0,lt = 0,rt = 0;
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                top = matrix[i][j]+dp[i-1][j];
                if(j-1>=0)
                    lt = matrix[i][j]+dp[i-1][j-1];
                else
                    lt = Integer.MAX_VALUE;
                if(j+1<m)
                    rt = matrix[i][j]+dp[i-1][j+1];
                else
                    rt =  Integer.MAX_VALUE;
                dp[i][j] = Math.min(top,Math.min(lt,rt));
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j=0;j<m;j++){
            min = Math.min(min,dp[n-1][j]);
        }
        return min;
    }
}