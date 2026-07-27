import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        //if(n == 0) return 1;
        Set<Character> set = new HashSet<>();
        int l = 0;
        int r = 0;
        int max = 0;
        while(r < n){
            if(!set.contains(s.charAt(r))){
                set.add(s.charAt(r));
                max = Math.max(max,r-l+1);
                r++;
            }
            else{
                set.remove(s.charAt(l));
                l++;
            }
        }
        return max;
    }
}