import java.util.*;

class Solution {
    public int cutRod(int[] price) {
        int n = price.length;
        int dp[][] = new int[n][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return tab(price,dp);
    }
    public static int rod(int ind,int[] price,int N,int dp[][]){
        if(ind == 0)
            return price[0]*N;
        if(dp[ind][N]!=-1)
            return dp[ind][N];
        int nottake = 0 + rod(ind-1,price,N,dp);
        int take = Integer.MIN_VALUE;
        int rodlen = ind+1;
        if(rodlen <= N)
            take = price[ind]+rod(ind,price,N-rodlen,dp);
        dp[ind][N] = Math.max(nottake,take);
        return dp[ind][N];
    }  
    public static int tab(int[] price,int dp[][]){
        int n = price.length;
        for(int i=0;i<=n;i++){
            dp[0][i] = price[0]*i;
        }
        for(int ind=1;ind<n;ind++){
            for(int N=0;N<=n;N++){
                int nottake = 0 + dp[ind-1][N];
                int take = Integer.MIN_VALUE;
                int rodlen = ind+1;
                if(rodlen <= N)
                    take = price[ind]+dp[ind][N-rodlen];
                dp[ind][N] = Math.max(nottake,take);
            }
        }
        return dp[n-1][n];
    }
}