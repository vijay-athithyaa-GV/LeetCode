import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0; 
        List<Integer> tem = new ArrayList<>();
        tem.add(nums[0]);
        for(int i=1;i<n;i++){
            int last = tem.get(tem.size()-1);
            if(nums[i]>last){
                tem.add(nums[i]);
            }else{
                int lb = lowerBound(0,tem.size()-1,nums[i],tem); //return the lowerbound index..
                tem.set(lb,nums[i]);
            }
        }
        return tem.size();
    }

    public int lowerBound(int l,int r,int x,List<Integer> tem){
        int ans = r;
        while(l<=r){
            int mid = (l+r)/2;
            if(tem.get(mid) >= x){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
}
