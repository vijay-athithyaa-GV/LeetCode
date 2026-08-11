class Solution {
    public int maximumCandies(int[] candies, long k) {
     //piles of candies-can[i];
    int n = candies.length;
    int min = Integer.MIN_VALUE;
    for(int i=0;i<n;i++) min = Math.max(min,candies[i]);
    int max = 0;
    // for(int i=1;i<=min;i++){
    //     if(isPossible(i,candies,k)){
    //         max = i;
    //     }else{
    //         return max;
    //     }
    // }
    int l = 1;
    int r = min;
    int ans = 0;
    while(l<=r){
        int mid = l+(r-l)/2;
        if(isPossible(mid,candies,k)){
            ans = mid;
            l = mid+1;
        }else{
            r = mid-1;
        }
    }
    return ans;
    }

    public boolean isPossible(int cnt,int arr[],long k){
        long tem=0l;
        for(int i=0;i<arr.length;i++){
          //  if(cnt>arr[i]) return false;
            tem = tem + (long)arr[i]/cnt;
        }
        if(tem>=k) return true;
        return false;
    }
}