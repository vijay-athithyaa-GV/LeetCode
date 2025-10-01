import java.util.*;

class Solution {
    public String reverseWords(String s) {
        List<String> res = Arrays.asList(s.trim().split("\\s+"));
        int n = res.size();
        String x = "";
        for(int i=n-1;i>=0;i--){
            x+=" "+res.get(i);
        }
        return x.trim();
    }
}