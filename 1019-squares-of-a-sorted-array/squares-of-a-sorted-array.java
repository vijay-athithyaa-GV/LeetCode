import java.util.*;

class Solution {
    public int[] sortedSquares(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            int val = Math.abs(nums[i]);
            res.add(val*val);
        }
        Collections.sort(res);
        int fin[] = new int[n];
        int i=0;
        for(int x:res){
            fin[i++] = x;
        }
        return fin;
    }
}