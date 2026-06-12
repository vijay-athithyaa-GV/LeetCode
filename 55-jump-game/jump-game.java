import java.util.*;

class Solution {
    public boolean canJump(int[] nums) {
       int n = nums.length;
       int dp[] = new int[n+1];
       Arrays.fill(dp,-1);
       return jump(nums,0,dp);
    }

    public boolean jump(int arr[],int ind,int dp[]){
        int n = arr.length;
        if(ind == n-1) return true;
        if(arr[ind] == 0 && (n-1)-ind>0) return false;
        if(dp[ind]!=-1) return dp[ind]==1;
        int size = arr[ind];
        for(int i=ind+1;i<=size+ind;i++){
            if(jump(arr,i,dp)){
                dp[ind] = 1;
                return true;
            }
        }
        dp[ind] = 0;
        return false;
    }
}