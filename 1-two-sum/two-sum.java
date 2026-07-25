import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int comple = target-nums[i];
            if(map.containsKey(comple)){
                return new int[]{map.get(comple),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}