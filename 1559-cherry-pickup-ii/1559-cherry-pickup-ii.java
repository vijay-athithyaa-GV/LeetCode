class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][][] = new int[n][m][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<m;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return che(grid,0,0,m-1,dp); 
    }
    public int che(int[][] gr,int i,int j1,int j2,int[][][] dp){
        int n = gr.length;
        int m = gr[0].length;
        if(j1<0 || j1>=m || j2<0 || j2>=m)
            return Integer.MIN_VALUE;
        if(i==n-1){//the i reaches the last row..
            if(j1 == j2)
                return gr[i][j1];
            else 
                return gr[i][j1]+gr[i][j2];
        }
        if(dp[i][j1][j2]!=-1)
            return dp[i][j1][j2];
        int maxi = 0;
        for(int dj1=-1;dj1<=1;dj1++){
            for(int dj2=-1;dj2<=1;dj2++){
                if(j1 == j2)
                    maxi = Math.max(maxi,gr[i][j1]+che(gr,i+1,j1+dj1,j2+dj2,dp));
                else
                     maxi = Math.max(maxi,gr[i][j1]+gr[i][j2]+che(gr,i+1,j1+dj1,j2+dj2,dp));
            }
        }
        dp[i][j1][j2] =  maxi;
        return maxi;
    }
}