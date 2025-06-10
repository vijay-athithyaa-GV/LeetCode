class Solution {//same as fibonacci
    public static int Climb(int ind,int dp[]){
        if(ind<=1)
            return 1;
        if(dp[ind]!=-1)
            return dp[ind];
        int l = Climb(ind-1,dp);
        int r = Climb(ind-2,dp);
        dp[ind] = l+r;
        return dp[ind];
    }
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        for(int i=0;i<=n;i++){
            dp[i] = -1;
        }
        return Climb(n,dp);
    }
}