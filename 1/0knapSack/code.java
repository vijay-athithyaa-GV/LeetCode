import java.util.*;

class Solution {
    static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int dp[][] = new int[n][W+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return Sack(n-1,val,wt,W,dp);
    }
    public static int Sack(int ind,int val[],int wt[],int w,int dp[][]){
        if(ind == 0){
            if(wt[ind]<=w)
                return val[ind];
            else
                return 0;
        }
        if(dp[ind][w]!=-1)
            return dp[ind][w];
        int nottake = 0 + Sack(ind-1,val,wt,w,dp);
        int take = Integer.MIN_VALUE;
        if(wt[ind]<=w)
            take = val[ind] + Sack(ind-1,val,wt,w-wt[ind],dp);
        dp[ind][w] = Math.max(nottake,take);
        return dp[ind][w];
    }
}
