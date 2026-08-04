import java.util.*;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //ith pile has piles[i] bananas
        //the guards have gone will come back in h hours.
        // randome -> eats k bananas from that pile. 
        // need to return K (min)
        int MOD = 1_000_000_000;
        int n = piles.length;
        Arrays.sort(piles);
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(piles[i],max);
        }
        int l = 1;
        int r = max;
        int ans = Integer.MAX_VALUE;
        while(l<=r){
            int mid = (l+r)/2;
            long tot = totHrs(mid,piles);
            // if(tot<=h && tot<ans) ans = tot;
            if(tot<=h){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }

    public long totHrs(int mid,int arr[]){
        int n = arr.length;
        long sum = 0;
        for(int i=0;i<n;i++){
            sum = sum + (arr[i]+mid-1)/mid;
        }
        return sum;
    }
}