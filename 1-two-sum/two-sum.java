import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        int n =nums.length;
        Map<Integer,Integer> m = new HashMap<>();
        for(int i=0;i<n;i++){
                int tem = target-nums[i];
                if(m.containsKey(tem)){
                    res[0] = i;
                    res[1] = m.get(tem);
                }
                m.put(nums[i],i);
            }  
        return res;
    }
}