import java.util.*;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1); 
        return stock(0,1,prices,dp);
    }
    public int stock(int ind,int buy,int p[],int dp[][]){
        int n = p.length;
        if(ind == n)
            return 0;
        if(dp[ind][buy]!=-1)
            return dp[ind][buy];
        int profit = 0;
        if(buy == 1)
            profit = Math.max(-p[ind]+stock(ind+1,0,p,dp),stock(ind+1,1,p,dp));
        else
            profit = Math.max(p[ind]+stock(ind+1,1,p,dp),stock(ind+1,0,p,dp));
        dp[ind][buy] = profit;
        return profit;
    }
}