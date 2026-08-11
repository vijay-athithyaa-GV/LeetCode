import java.util.*;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int k = 0;
        int max = 0;
        int l = 1;
        for(int i=0;i<n;i++) max = Math.max(piles[i],max);
        while(l<=max){
            int mid = l+(max-l)/2;
            if(isPossible(mid,piles,h)){
                k = mid;
                max = mid-1;
            }else{
                l = mid+1;
            }
        }
        return k;
    }

    public boolean isPossible(int k,int arr[],int h){
        int temHr = 0;
        for(int i=0;i<arr.length;i++){
            temHr += (arr[i]+k-1)/k;
            if(temHr > h) return false;
        }
        return true;
    }
}