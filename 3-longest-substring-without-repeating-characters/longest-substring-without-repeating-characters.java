import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int len = 0;
        int maxlen = 0;
        for(int i=0;i<n;i++){
            Map<Character,Integer> map = new HashMap<>();
            for(int j=i;j<n;j++){
                if(map.containsKey(s.charAt(j))) break;
                len = j-i+1;
                maxlen = Math.max(maxlen,len);
                map.put(s.charAt(j),1);
            }
        }
        return maxlen;
    }
}