import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
       int n = coins.length;
       int dp[][] = new int[n][amount+1];
       for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
       int ans = minCoins(n-1,coins,amount,dp);
       return (ans==Integer.MAX_VALUE)?-1:ans;
    }
    public int minCoins(int ind,int[] coins,int amt,int dp[][]){
        if(ind == 0)
        {
            if(amt%coins[ind] == 0)
                return amt/coins[0];
            return Integer.MAX_VALUE;
        }
        if(dp[ind][amt]!=-1)
            return dp[ind][amt];
        int nottake = minCoins(ind-1,coins,amt,dp);
        int take = Integer.MAX_VALUE;
        if(coins[ind]<=amt){
            int res = minCoins(ind,coins,amt-coins[ind],dp);
            if(res!=Integer.MAX_VALUE)
                take = 1 + res;
        }
        dp[ind][amt] = Math.min(take,nottake);
        return dp[ind][amt];
    }
}