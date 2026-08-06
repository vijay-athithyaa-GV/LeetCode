import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        int res = findCoins(n-1,coins,amount,dp);
        return res==Integer.MAX_VALUE?-1:res;
    }

    public int findCoins(int ind,int arr[],int amt,int dp[][]){
        if(ind == 0){
            if(amt%arr[0] == 0)
                return amt/arr[0];
            else return Integer.MAX_VALUE;
        }
        if(dp[ind][amt]!=-1) return dp[ind][amt];
        int right = findCoins(ind-1,arr,amt,dp);
        int left = Integer.MAX_VALUE;
        if(arr[ind]<=amt){
            int res = findCoins(ind,arr,amt-arr[ind],dp);
            if(res != Integer.MAX_VALUE){
                left = 1+res;
            }
        }
        return dp[ind][amt]=Math.min(left,right);
    }
}