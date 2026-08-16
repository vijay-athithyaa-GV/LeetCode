import java.util.*;
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for(int x:arr){
            int prev = x-difference;
            int len = map.getOrDefault(prev,0)+1;
            map.put(x,len);
            ans = Math.max(len,ans);
        }
        return ans;
    }
}