import java.util.*;

class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int prev = nums[0];
        for(int i=1;i<n;i++){
            if(prev == nums[i]){
                return prev;
            }
            prev = nums[i];
        }
        return -1;
    }
}