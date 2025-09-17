import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        int res = 0;
        for(int i=0;i<nums.length;i++){
            p.add(nums[i]);
        }
        for(int j=0;j<k;j++){
            res = p.poll();
        }
        return res;
    }
}