import java.util.*;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return profits(0,1,prices,dp);        
    }

    public int profits(int ind,int buy,int arr[],int dp[][]){
        int n = arr.length;
        if(ind == n) return 0;
        int max = Integer.MIN_VALUE;
        if(dp[ind][buy]!=-1) return dp[ind][buy];

        if(buy==1){
            int pro = -arr[ind]+profits(ind+1,0,arr,dp);
            int not = profits(ind+1,1,arr,dp);
            max = Math.max(pro,not);
        }else{
            int pro = arr[ind]+profits(ind+1,1,arr,dp);
            int not = profits(ind+1,0,arr,dp);
            max = Math.max(pro,not);
        }
        return dp[ind][buy] = max;
    }
}