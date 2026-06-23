import java.util.*;

class Solution {
   
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int lane = 2;
        int frogpos = 0;
        int dp[][] = new int[n+1][4];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return jumps(frogpos,lane,obstacles,dp);
    }

    public int jumps(int frogpos,int lane,int obs[],int dp[][]){
        int n = obs.length;
        if(frogpos == n-1) return 0;
        int minj = Integer.MAX_VALUE;
        if(dp[frogpos][lane]!=-1) return dp[frogpos][lane];
        if(obs[frogpos+1]!=lane){
             minj = jumps(frogpos+1,lane,obs,dp);
        }
        else{
            for(int i=1;i<=3;i++){
                if(lane == i) continue;
                if(obs[frogpos]!=i){
                    minj = Math.min(minj,1+jumps(frogpos,i,obs,dp));
                }      
            }
        }
        return dp[frogpos][lane] = minj;
    }
}