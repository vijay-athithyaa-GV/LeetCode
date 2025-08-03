import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> m = new HashSet<>();
        int n = s.length();
        int l = 0;
        int r = 0;
        int maxlen = 0;
        while(r<n){
            if(!m.contains(s.charAt(r))){
                maxlen = Math.max(maxlen,r-l+1);
                m.add(s.charAt(r));
                r++;
            }
            else{
                m.remove(s.charAt(l));
                l++;
            }
        }
        return maxlen;
    }
}