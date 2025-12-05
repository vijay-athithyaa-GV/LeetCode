import java.util.*;

class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int maxlen = 0;
        map.put(sum,-1);
        for(int i=0;i<n;i++){
            if(nums[i] == 0)
                nums[i] = -1;
        }
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(!map.containsKey(sum)) map.put(sum,i);
            else{
                        if(maxlen<i-(map.get(sum)))
                        {
                            maxlen = i-(map.get(sum));
                        }
            }    
        }
        return maxlen;
    }
}