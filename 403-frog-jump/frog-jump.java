import java.util.*;

class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        Boolean dp[][] = new Boolean[n][n+1];
        return cross(0,0,stones,dp);
    }

    public boolean cross(int pre, int ind,int arr[],Boolean dp[][]){
        int n = arr.length;
        if(ind == n-1) return true;  
        if(dp[ind][pre]!=null) return dp[ind][pre];
        for(int next=pre-1;next<=pre+1;next++){
            if(next<=0) continue;
            int nextpos=next+arr[ind];
            for(int i=ind+1;i<n;i++){
                if(arr[i] == nextpos){
                    if(cross(next,i,arr,dp)){
                        return dp[ind][pre] = true;
                    }
                }
            }
        }
         return dp[ind][pre] = false;
    }
}