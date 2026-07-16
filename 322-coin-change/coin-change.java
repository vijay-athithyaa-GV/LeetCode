import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],1000000);
        // int res = coins(n-1,amount,coins,dp);
        // return res==1000000?-1:res;
        int res = tab(coins,amount,dp);
        return res==1000000?-1:res;
    }

    public int coins(int ind,int amt,int[] coins,int dp[][]){
        if(ind == 0){
            if(amt%coins[0] == 0){
                return amt/coins[0];
            }
            else return 1000000;
        }
        if(dp[ind][amt]!=1000000) return dp[ind][amt];

        int left = 1000000;
        if(amt>=coins[ind]) left = coins(ind,amt-coins[ind],coins,dp)+1;
        int right = coins(ind-1,amt,coins,dp);
        return dp[ind][amt] = Math.min(left,right);
    }

    public int tab(int[] coins,int amount,int dp[][]){
        int n = coins.length;
        for(int i=0;i<=amount;i++){
            if(i%coins[0] == 0){
                dp[0][i] = i/coins[0];
            }
            else{
                dp[0][i] = 1000000;
            }
        }
        for(int ind=1;ind<n;ind++){
            for(int amt=0;amt<=amount;amt++){
                int left = 1000000;
                if(amt>=coins[ind]) left = dp[ind][amt-coins[ind]]+1;
                int right = dp[ind-1][amt];
                dp[ind][amt] = Math.min(left,right);
            }
        }
        return dp[n-1][amount];
    }
}