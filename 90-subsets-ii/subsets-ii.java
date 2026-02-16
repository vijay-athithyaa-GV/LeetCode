import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n=nums.length;
        int sublen = 1<<n;
        List<List<Integer>> res;
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0;i<sublen;i++){
            List<Integer> arr = new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i &(1<<j))!=0){
                    arr.add(nums[j]);
                }
            }
            Collections.sort(arr);
            set.add(arr);
        }
       res = new ArrayList<>(set);
       return res;
    }
}