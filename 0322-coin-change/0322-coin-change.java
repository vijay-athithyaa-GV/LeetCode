import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
       int n = coins.length;
       int dp[][] = new int[n][amount+1];
       for(int i=0;i<n;i++)
            Arrays.fill(dp[i],0);
        int ans = Tabu(coins,amount,dp);
        return (ans == Integer.MAX_VALUE)?-1:ans;
    }
    public int Tabu(int coins[],int amt,int dp[][]){
        int n = coins.length;
        for(int t=0;t<=amt;t++){
            if(t%coins[0] == 0)
                dp[0][t] = t/coins[0];
            else
                dp[0][t] = Integer.MAX_VALUE;
        }

        for(int i=1;i<n;i++){
            for(int tar = 0;tar<=amt;tar++){
                int nottake = dp[i-1][tar];
                int take = Integer.MAX_VALUE;
                if(coins[i]<=tar){
                    int res = dp[i][tar-coins[i]];
                    if(res!=Integer.MAX_VALUE)
                        take = 1 + res;
                }
                dp[i][tar] = Math.min(take,nottake); 
            }
        }
        return dp[n-1][amt];
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