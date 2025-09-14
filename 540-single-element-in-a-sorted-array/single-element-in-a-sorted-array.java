import java.util.*;

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> pair = new HashMap<>();
        for(int i=0;i<n;i++){
            if(pair.containsKey(nums[i])){
                int val = pair.get(nums[i]);
                pair.put(nums[i],val+1);
            }
            else
                pair.put(nums[i],1);
        }
        int res = 0;
        for(int x:pair.keySet()){
            if(pair.get(x)==1)
                return x;
        }
        return -1;
    }
}