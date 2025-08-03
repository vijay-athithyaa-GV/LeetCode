import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
         int n = nums.length;
        if(nums.length == 0)
            return 0;
        Set<Integer> st = new HashSet<>();
        for(int i=0;i<n;i++){
            st.add(nums[i]);
        }
        int[] arr = st.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(arr);
        int x = arr[0];
        int count = 1;
        int maxlen = 1;
        for(int i=1;i<arr.length;i++){
            if(arr[i] == x+1){
                count++;
                x = arr[i];
                maxlen = Math.max(count,maxlen);
            }
            else{
                count = 1;
                x = arr[i];
                maxlen = Math.max(count,maxlen);
            }
        }
    return maxlen;    
    }
}