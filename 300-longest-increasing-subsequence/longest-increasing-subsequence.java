import java.util.*;
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return findLen(0,-1,nums,dp);
    }
    public int findLen(int ind,int prev,int arr[],int[][] dp){
        int n = arr.length;
        if(ind == n) return 0;
        if(dp[ind][prev+1]!=-1) return dp[ind][prev+1];
        int max = Integer.MIN_VALUE;
        int left = -1;
        int right = -1;
        if(prev == -1 ||arr[ind] > arr[prev]) left = findLen(ind+1,ind,arr,dp)+1;
        right = findLen(ind+1,prev,arr,dp);
        return dp[ind][prev+1] = Math.max(left,right);
    }
}