import java.util.*;

class Solution {
    public int paintWalls(int[] cost, int[] time) {
        //two painter.
        //1. Paid painter -> time[i] with + cost[i]
        //2. free painter -> 1 + 0; (only when the paid is occupied) - parallel operation..
        //return min..
        //here we are getting the min(paid)+min(unpaid)
        int n = cost.length;
        int dp[][] = new int[n][n+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],1000000000);
        //return paint(n-1,cost,time,n,dp);
        return tab(cost,time,dp);
    }

    public int paint(int ind,int cost[],int time[],int wall,int dp[][]){
        if(wall<=0) return 0;
        if(ind == 0){
            if(wall<=time[0]+1) return cost[0];
            else return 1000000000;
        }
        if(dp[ind][wall]!=1000000000) return dp[ind][wall];
        int left = paint(ind-1,cost,time,wall-time[ind]-1,dp)+cost[ind];
        int right = paint(ind-1,cost,time,wall,dp);
        return dp[ind][wall] = Math.min(left,right);    
    }
    
    public int tab(int cost[],int time[],int dp[][]){
        int n = cost.length;
        for(int i=0;i<n;i++){
            dp[i][0] = 0;
        }
        // for(int i=0;i<=n;i++){
        //     dp[0][i] = 1000000000;
        // }
        for(int wall=1;wall<=n;wall++){
            if(wall<=time[0]+1) dp[0][wall] = cost[0];
            else dp[0][wall] = 1000000000;
        }

        for(int ind=1;ind<n;ind++){
            for(int wall=1;wall<=n;wall++){
                int left = dp[ind-1][Math.max(0,wall-time[ind]-1)]+cost[ind];
                int right = dp[ind-1][wall];
                dp[ind][wall] = Math.min(left,right); 
            }
        }
        return dp[n-1][n];
    }

}