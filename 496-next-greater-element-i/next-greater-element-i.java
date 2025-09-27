import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        int n = nums1.length;
        int m = nums2.length;
        int res[] = new int[n];
        for(int x:nums2){
            while(!st.empty() && st.peek()<=x){
                map.put(st.pop(),x);
            }
            st.push(x);
        }
        for(int i=0;i<n;i++){
            res[i] = map.getOrDefault(nums1[i],-1);
        }
        return res;
    }
}