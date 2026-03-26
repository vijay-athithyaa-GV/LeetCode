import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxlen = 0;
        
        for(int i=0;i<n;i++){
            int pos = 0;
            Map<Character,Integer> map = new HashMap<>();
            map.put(s.charAt(i),1);
            for(int j=i+1;j<n;j++){
                if(map.containsKey(s.charAt(j))) break;
                else{
                    map.put(s.charAt(j),1);
                }
                pos = j;
            }
            maxlen = Math.max(maxlen,pos-i+1);
        }
        return maxlen;
    }
}