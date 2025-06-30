import java.util.*;
class Solution {  

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return changeCount(n-1,coins,amount,dp);
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
}
