import java.util.*;

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        //need to find the repeated and missing no.
         //res[0] = repeated value then res[1] = missing no.
        int n = grid.length;
        int cnt[] = new int[n*n+1];
        Arrays.fill(cnt,0);
        for(int i=0;i<n;i++){
            for(int x:grid[i]){
                cnt[x]++;
            }
        }
        int res[] = new int[2];
        for(int i=1;i<=n*n;i++){
            if(cnt[i]>=2){
                res[0] = i;
            }
            if(cnt[i] == 0){
                res[1] = i;
            }
        }
        return res;
    }
}