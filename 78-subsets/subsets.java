import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        int sublen = 1<<n;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<sublen;i++){
            List<Integer> arr = new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i &(1<<j))!=0){
                    arr.add(nums[j]);
                }
            }
            res.add(arr);
        }
        return res;
    }
}