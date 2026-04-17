import java.util.*;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)  return nums[0];
        int dp1[] = new int[n];
        int dp2[] = new int[n];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        int lastleft = robdb(0,n-2,nums,dp1);
        int fistleft = robdb(1,n-1,nums,dp2);
        return Math.max(lastleft,fistleft);
    }
    public int robdb(int start,int ind,int arr[],int dp[]){
        if(ind == start) return arr[ind];
        if(ind < start) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int pick = arr[ind]+robdb(start,ind-2,arr,dp);
        int notpick = robdb(start,ind-1,arr,dp);
        dp[ind] = Math.max(pick,notpick);
        return dp[ind];
    }
}