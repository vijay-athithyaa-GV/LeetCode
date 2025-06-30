import java.util.*;
class Solution {  

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return changeTab(coins,amount,dp);
    }
    public int changeCount(int ind,int[] coins,int amt,int dp[][]){
        if(ind == 0){
            if(amt%coins[ind] == 0) return 1;
            else return 0;
        }
        if(dp[ind][amt]!=-1)
            return dp[ind][amt];
        int nottake = changeCount(ind-1,coins,amt,dp);
        int take = 0;
        if(coins[ind] <= amt)
            take = changeCount(ind,coins,amt-coins[ind],dp);
        dp[ind][amt] = take+nottake;
        return dp[ind][amt];
    }
    //tabulation code...
    public int changeTab(int[] coins,int amt,int dp[][]){
        int n = coins.length;
        for(int t=0;t<=amt;t++){
            if(t%coins[0] == 0)
                dp[0][t] = 1;
            else 
                dp[0][t] = 0;
        }
        for(int i=1;i<n;i++){
            for(int t=0;t<=amt;t++){
                int nottake = dp[i-1][t];
                int take = 0;
                if(coins[i] <= t)
                    take = dp[i][t-coins[i]];
                dp[i][t] = take+nottake;
            }
        }
        return dp[n-1][amt];
    }
}
