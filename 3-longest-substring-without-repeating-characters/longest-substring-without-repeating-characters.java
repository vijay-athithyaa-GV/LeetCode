import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int len = 0;
        int maxlen = 0;
        int r = 0,l = 0;
        Map<Character,Integer> map = new HashMap<>();
        while(r<n){
            char c = s.charAt(r);
            if(map.containsKey(c)){
                if(map.get(c)>=l){
                    l = map.get(c)+1;
                    map.put(c,l);
                }
            }
            len = r-l+1;
            maxlen = Math.max(maxlen,len);
            map.put(c,r);
            r++;
        }

        return maxlen;
    }
}